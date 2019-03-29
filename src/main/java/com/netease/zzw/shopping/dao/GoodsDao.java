package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GoodsDao extends JpaRepository<Goods, Long>  {

    /*
     * 添加商品
     * */
    @Query(value = "insert into Goods (name, price, summary, description, graph) values (?, ?, ?, ?, ?)", nativeQuery = true)
    @Transactional
    @Modifying
    void addGoods(@Param("name") String name,
                  @Param("price") BigDecimal price,
                  @Param("summary") String summary,
                  @Param("description") String description,
                  @Param("graph") String graph);

    /*
     * 查询全部商品
     * */
    @Query("select t from Goods t")
    List<Goods> findAll();
}