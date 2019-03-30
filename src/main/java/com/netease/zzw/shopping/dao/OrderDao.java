package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>  {
    /*
     * 添加订单
     * */
    @Query(value = "insert into `Order` (user_id, goods_id, buy_time, amount, state) values (?, ?, ?, ?, ?)",
            nativeQuery = true)
    @Transactional
    @Modifying
    void addOrder(@Param("userId") long userId,
                  @Param("goodsId") long goodsId,
                  @Param("buyTime") Date buyTime,
                  @Param("amount") int amount,
                  @Param("state") int state);

    /*
     * 查询某一状态的订单
     * */
    @Query(value = "select * from `Order` where state = ?", nativeQuery = true)
    List<Order> findOrderByState(@Param("state") int state);
}
