package com.netease.zzw.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.zzw.shopping.config.GoodsConst;
import com.netease.zzw.shopping.config.UserConst;
import com.netease.zzw.shopping.dto.GoodsIndexDto;
import com.netease.zzw.shopping.dto.UserRoleDto;
import com.netease.zzw.shopping.model.Goods;
import com.netease.zzw.shopping.service.GoodsService;
import com.netease.zzw.shopping.service.UserService;
import com.netease.zzw.shopping.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    private String imageSavePath = getImageSavePath();
    private String delimiter = "_shoppingProjectImage_";

    private String getImageSavePath() {
        return new File("images").getAbsolutePath();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexGoods(@RequestParam(value = "type", required = false, defaultValue = "0") int type,
                                    Model model) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();

        List<GoodsIndexDto> goodsIndexDtoList = goodsService.getGoodsIndexShowDto(userRoleDto.getUserName(), userRoleDto.getRoleName(), type);
        model.addAttribute("goodsList", goodsIndexDtoList);
        model.addAttribute("userRoleDto", userRoleDto);
        return "/index";
    }

    @RequestMapping(value = "/goods/show", method = RequestMethod.GET)
    public String showGoods(@RequestParam(value = "id") long id, Model model) {
        boolean isBuyed = true;
        long amount = 0;
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        // 登录
        if(!userRoleDto.getUserName().equals("") && !userRoleDto.getUserName().isEmpty()) {
            long userId = userService.findUserByUserName(userRoleDto.getUserName()).getId();
            if(userRoleDto.getUserName().equals(UserConst.RoleName.buyer.name())) {
                amount = goodsService.getGoodsUserBuyedAmount(userId, id);
            } else if(userRoleDto.getUserName().equals(UserConst.RoleName.seller.name())) {
                amount = goodsService.getAllBuyGoodsAmount(id);
            }

            if(amount < 0) {
                isBuyed = false;
                amount = 0;
            }
        }


        Goods goods = goodsService.getGoodsById(id);
        model.addAttribute("goods", goods);
        model.addAttribute("amount", amount);
        model.addAttribute("isBuyed", isBuyed);
        model.addAttribute("userRoleDto", userRoleDto);
        return "/goods/show";
    }

    @RequestMapping(value = "/goods/public", method = RequestMethod.GET)
    public String publicGoods(Model model) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {
            model.addAttribute("userRoleDto", userRoleDto);
            return "/goods/public";
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/goods/edit", method = RequestMethod.GET)
    public String publicGoods(@RequestParam(value = "id") long id,
                              Model model) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {
            Goods goods = goodsService.getGoodsById(id);
            model.addAttribute("goods", goods);
            model.addAttribute("userRoleDto", userRoleDto);
            return "/goods/edit";
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/goods/publicSubmit", method = RequestMethod.POST)
    public String toPublicGoods(@RequestParam(value = "title") String name,
                                @RequestParam(value = "summary") String summary,
                                @RequestParam(value = "pic") String graphSource,
                                @RequestParam(value = "image") String graphLink,
                                @RequestParam(value = "file") String fileName,
                                @RequestParam(value = "detail") String description,
                                @RequestParam(value = "price") BigDecimal price) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {
            long publisherId = userService.findUserByUserName(userRoleDto.getUserName()).getId();
            String graphName;
            if (fileName == null || fileName.isEmpty()) {
                graphName = getFileNameAndSuffixFromPath(graphLink);
            } else {
                graphName = fileName;
            }

            // 验证价格是否小于0
            if(price.compareTo(new BigDecimal(0)) < 0) {
                return "redirect:/goods/public";
            }
            goodsService.addGoods(name, publisherId, price, summary, description, graphName, graphSource, graphLink);
            return "redirect:/";
        }

        return "redirect:/user/login";
    }

    @RequestMapping(value = "/goods/editSubmit", method = RequestMethod.POST)
    public String toPublicGoods(@RequestParam(value = "id") long id,
                                @RequestParam(value = "title") String name,
                                @RequestParam(value = "summary") String summary,
                                @RequestParam(value = "pic") String graphSource,
                                @RequestParam(value = "image") String graphLink,
                                @RequestParam(value = "file") String fileName,
                                @RequestParam(value = "detail") String description,
                                @RequestParam(value = "price") BigDecimal price) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {

            long publisherId = userService.findUserByUserName(userRoleDto.getUserName()).getId();
            String graphName;
            if (fileName == null || fileName.isEmpty()) {
                graphName = getFileNameAndSuffixFromPath(graphLink);
            } else {
                graphName = fileName;
            }

            // 验证价格是否小于0
            if(price.compareTo(new BigDecimal(0)) < 0) {
                return "redirect:/goods/edit?id="+id;
            }
            deleteGraph(id);
            goodsService.updateGoodsById(id, name, publisherId, price, summary, description, graphName, graphSource, graphLink);
            return "redirect:/";
        }

        return "redirect:/user/login";
    }

    private String getFileNameAndSuffixFromPath(String path) {
        String[] filePathAndName = path.split("/");
        String fileNameAndSuffix = filePathAndName[filePathAndName.length - 1];
        return fileNameAndSuffix;
    }

    @RequestMapping(value = "/api/goods/image/upload", method = RequestMethod.POST)
    @ResponseBody
    public String imageUpload(@RequestParam(value = "file") MultipartFile file) {
        JSONObject resultPath = new JSONObject();
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {

            String fileName = file.getOriginalFilename();
            String filePath = imageSavePath + "/";
            fileName = UUID.randomUUID() + delimiter + fileName;
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }


            resultPath.put("code", 200);
            resultPath.put("result", GoodsConst.relativePath + fileName);
            return resultPath.toJSONString();
        }
        resultPath.put("code", 400);
        return resultPath.toJSONString();
    }

    private void deleteGraph(long goodsId) {
        // 判断是否需要删除图片
        Goods goods = goodsService.getGoodsById(goodsId);
        if (goods.getGraphSource().equals(GoodsConst.GraphSource.file.name())) {
            String graphNameAndSuffix = getFileNameAndSuffixFromPath(goods.getGraphLink());
            String graphPath = imageSavePath + "/" + graphNameAndSuffix;
            File graphFile = new File(graphPath);
            // TODO 返回值是boolean，最好做一下判断看是否成功删除
            graphFile.delete();
        }
    }

    @RequestMapping(value = "/api/goods/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteGoods(@RequestParam(value = "id") long id) {
        JSONObject resultId = new JSONObject();

        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.seller.name())) {

            deleteGraph(id);
            if (goodsService.deleteGoodsById(id) == 0) {
                resultId.put("code", 404);
                resultId.put("id", -1);
                return resultId.toJSONString();
            }
            resultId.put("code", 200);
            resultId.put("id", id);
            return resultId.toJSONString();
        }

        resultId.put("code", 400);
        return resultId.toJSONString();
    }
}
