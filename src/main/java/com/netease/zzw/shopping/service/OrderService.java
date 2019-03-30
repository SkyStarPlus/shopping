package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.dto.OrderDto;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void  addOrder(long userId, long goodsId, Date buyTime, int amount, int state);

    List<OrderDto> getOrderDtoByState(int state);
}
