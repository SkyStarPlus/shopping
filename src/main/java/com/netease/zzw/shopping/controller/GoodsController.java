package com.netease.zzw.shopping.controller;

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
import java.util.UUID;

@Controller
public class GoodsController {

    private String imageSavePath = getImageSavePath();
    private String delimiter = "_shoppingProjectImage_";

    private String getImageSavePath() {
        return new File("image").getAbsolutePath();
    }

    @RequestMapping(value = "/goods/public", method = RequestMethod.GET)
    public String publicGoods() {
        return "/goods/public";
    }

    @RequestMapping(value = "/goods/publicSubmit", method = RequestMethod.POST)
    public String toPublicGoods(@RequestParam(value = "title") String name,
                                @RequestParam(value = "summary") String summary,
                                @RequestParam(value = "image") String graph,
                                @RequestParam(value = "detail") String description,
                                @RequestParam(value = "price") BigDecimal price) {

        return "/index";
    }

    @RequestMapping(value = "/goods/image/upload", method = RequestMethod.POST)
    @ResponseBody
    public String imageUpload(@RequestParam(value = "file") MultipartFile file,
                              Model model) {
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

//        model.addAttribute("image", dest);
//        return "/goods/public";
    }

}