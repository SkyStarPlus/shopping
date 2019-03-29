package com.netease.zzw.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.zzw.shopping.config.GoodsConst;
import com.netease.zzw.shopping.model.Goods;
import com.netease.zzw.shopping.service.GoodsService;
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

    private String imageSavePath = getImageSavePath();
    private String delimiter = "_shoppingProjectImage_";

    private String getImageSavePath() {

        return new File("images").getAbsolutePath();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexGoods(Model model) {
        List<Goods> goodsList = goodsService.getAllGoods();
        model.addAttribute("goodsList", goodsList);
        return "/index";
    }

    @RequestMapping(value = "/goods/show", method = RequestMethod.GET)
    public String showGoods(@RequestParam(value = "id") long id, Model model) {
        Goods goods = goodsService.getGoodsById(id);
        model.addAttribute("goods", goods);
        return "/goods/show";
    }

    @RequestMapping(value = "/goods/public", method = RequestMethod.GET)
    public String publicGoods() {
        return "/goods/public";
    }

    @RequestMapping(value = "/goods/publicSubmit", method = RequestMethod.POST)
    public String toPublicGoods(@RequestParam(value = "title") String name,
                                @RequestParam(value = "summary") String summary,
                                @RequestParam(value = "pic") String graphSource,
                                @RequestParam(value = "image") String graphLink,
                                @RequestParam(value = "file") String fileName,
                                @RequestParam(value = "detail") String description,
                                @RequestParam(value = "price") BigDecimal price) {
        //TODO 校验
        String graphName = "null";
        if (fileName == null || fileName.isEmpty()) {
            String[] filePathAndName = graphLink.split("/");
            graphName = filePathAndName[filePathAndName.length - 1];
        } else {
            graphName = fileName;
        }

        // 验证价格是否小于0
        if(price.compareTo(new BigDecimal(0)) < 0) {
            return "/goods/public";
        }
        goodsService.addGoods(name, price, summary, description, graphName, graphSource, graphLink);
        return "/index";
    }

    @RequestMapping(value = "/goods/image/upload", method = RequestMethod.POST)
    @ResponseBody
    public String imageUpload(@RequestParam(value = "file") MultipartFile file) {
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

        JSONObject resultPath = new JSONObject();
        resultPath.put("result", GoodsConst.relativePath + fileName);
        return resultPath.toJSONString();
    }

}
