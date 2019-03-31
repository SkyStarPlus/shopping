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
    @Query(value = "select * from `Order` where user_id = :userId and state = :state", nativeQuery = true)
    List<Order> findOrdersByState(@Param("userId") long userId,
                                  @Param("state") int state);

    /*
     * 变更某一订单的数量和状态
     * */
    @Query(value = "update `Order` set amount = :amount, state = :state where id = :id", nativeQuery = true)
    @Transactional
    @Modifying
    void updateOrderAmountAndState(@Param("id") long id,
                                          @Param("amount") int amount,
                                          @Param("state") int state);

    /**
     * 根据商品id列表查询订单
     * @param goodsIdList
     * @return
     */
    @Query(value = "select * from `order` where goods_id in (:goodsIdList)", nativeQuery = true)
    List<Order> findOrdersByGoodsId(@Param("goodsIdList") List<Long> goodsIdList);

    @Query(value = "select * from `order` where goods_id = :goodsId", nativeQuery = true)
    List<Order> findOrdersByGoodsId(@Param("goodsId") long goodsId);

    /**
     * 根据用户Id查询订单
     * @param userId
     * @return
     */
    @Query(value = "select * from `order` where user_id = :userId", nativeQuery = true)
    List<Order> findOrdersByUserId(@Param("userId") long userId);

    @Query(value = "select * from `order` where user_id = :userId and goods_id = :goodsId", nativeQuery = true)
    Order findOrderByUserIdAAndGoodsId(@Param("userId") long userId,
                                       @Param("goodsId") long goodsId);

}
