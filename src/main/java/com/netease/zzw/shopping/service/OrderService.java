package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dto.OrderDto;
import com.netease.zzw.shopping.dto.OrderPayedDto;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void  addOrder(long userId, long goodsId, Date buyTime, int amount, int state);

    void updateOrderAmountAndState(long id, int amount, int state);

    List<OrderDto> getOrderDtoByState(long userId, int state);

    List<OrderPayedDto> getOrderPayedDto(long userId);
}
