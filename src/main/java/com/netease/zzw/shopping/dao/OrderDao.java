package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>  {
    /*
     * 添加订单
     * */
    @Query(value = "insert into Order (userId, goodsId, buyTime, amount, state) values (?, ?, ?, ?, ?)",
            nativeQuery = true)
    @Transactional
    @Modifying
    void addOrder(@Param("userId") long userId,
                  @Param("goodsId") long goodsId,
                  @Param("buyTime") Date buyTime,
                  @Param("amount") String summary,
                  @Param("state") String description);

}
