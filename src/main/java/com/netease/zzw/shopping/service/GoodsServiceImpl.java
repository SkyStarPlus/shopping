package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dao.GoodsDao;
import com.netease.zzw.shopping.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void addGoods(String name, BigDecimal price, String summary, String description,
                         String graphName, String graphSource, String graphLink) {
        goodsDao.addGoods(name, price, summary, description, graphName, graphSource, graphLink);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.findAll();
    }

    @Override
    public Goods getGoodsById(long id) {
        return goodsDao.findById(id);
    }
}
