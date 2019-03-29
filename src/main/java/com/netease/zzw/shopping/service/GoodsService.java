package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.model.Goods;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsService {
    void addGoods(String name, BigDecimal price, String summary, String description, String graph);

    List<Goods> getAllGoods();
}