package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dao.GoodsDao;
import com.netease.zzw.shopping.dao.OrderDao;
import com.netease.zzw.shopping.dto.OrderDto;
import com.netease.zzw.shopping.model.Goods;
import com.netease.zzw.shopping.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void addOrder(long userId, long goodsId, Date buyTime, int amount, int state) {
        orderDao.addOrder(userId, goodsId, buyTime, amount, state);
    }

    @Override
    public List<OrderDto> getOrderDtoByState(int state) {
        List<Order> orderList = orderDao.findOrderByState(state);
        List<Long> goodsIdList = new ArrayList<>();
        for(Order order : orderList) {
            goodsIdList.add(order.getGoodsId());
        }
        List<Goods> goodsList = goodsDao.getGoodsByIds(goodsIdList);

        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            for (Goods goods : goodsList) {
                if(goods.getId() == order.getGoodsId()) {
                    BigDecimal totalPrice = goods.getPrice().multiply(new BigDecimal(order.getAmount()));
                    OrderDto orderDto = new OrderDto(order.getId(),
                            order.getUserId(),
                            order.getGoodsId(),
                            goods.getName(),
                            order.getBuyTime(),
                            order.getAmount(),
                            goods.getPrice(),
                            totalPrice);
                    orderDtoList.add(orderDto);
                    break;
                }
            }


        }
        return orderDtoList;
    }
}
