package com.netease.zzw.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.zzw.shopping.config.OrderConst;
import com.netease.zzw.shopping.dto.OrderDto;
import com.netease.zzw.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/order/addShoppingCart", method = RequestMethod.POST)
    @ResponseBody
    public String addShoppingCart(@RequestParam(value = "goodsId") long goodsId,
                                  @RequestParam(value = "num") int amount) {
        long userId = 2;
        orderService.addOrder(userId, goodsId, new Date(), amount, OrderConst.State.SHOPPINGCART.ordinal());

        JSONObject resultPath = new JSONObject();
        resultPath.put("code", 200);
        return resultPath.toJSONString();
    }

    @RequestMapping(value = "/order/settleAccount", method = RequestMethod.GET)
    public String settleAccount(Model model) {
        List<OrderDto> orderDtoList = orderService.getOrderDtoByState(OrderConst.State.SHOPPINGCART.ordinal());
        model.addAttribute("orderDtoList", orderDtoList);
        return "/order/settleAccount";
    }
}
