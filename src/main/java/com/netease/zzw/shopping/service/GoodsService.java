package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dto.GoodsIndexDto;
import com.netease.zzw.shopping.model.Goods;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsService {
    void addGoods(String name, long publisherId, BigDecimal price, String summary, String description,
                  String graphName, String graphSource, String graphLink);

    void updateGoodsById(long id, String name, long publisherId, BigDecimal price, String summary, String description,
                  String graphName, String graphSource, String graphLink);

    List<Goods> getAllGoods();

    List<GoodsIndexDto> getGoodsIndexShowDto(String userName, String roleName, int type);

    Goods getGoodsById(long id);

    int deleteGoodsById(long id);

    int getGoodsUserBuyedAmount(long userId, long goodsId);

    long getAllBuyGoodsAmount(long goodsId);
}
