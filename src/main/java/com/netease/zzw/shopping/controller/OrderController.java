package com.netease.zzw.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.zzw.shopping.config.OrderConst;
import com.netease.zzw.shopping.config.UserConst;
import com.netease.zzw.shopping.dto.OrderDto;
import com.netease.zzw.shopping.dto.OrderPayedDto;
import com.netease.zzw.shopping.dto.UserRoleDto;
import com.netease.zzw.shopping.service.OrderService;
import com.netease.zzw.shopping.service.UserService;
import com.netease.zzw.shopping.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/order/addShoppingCart", method = RequestMethod.POST)
    @ResponseBody
    public String addShoppingCart(@RequestParam(value = "goodsId") long goodsId,
                                  @RequestParam(value = "num") int amount) {
        long userId = 2;
        // TODO 做校验
        orderService.addOrder(userId, goodsId, new Date(), amount, OrderConst.State.SHOPPINGCART.ordinal());

        JSONObject resultPath = new JSONObject();
        resultPath.put("code", 200);
        return resultPath.toJSONString();
    }

    @RequestMapping(value = "/order/settleAccount", method = RequestMethod.GET)
    public String settleAccount(Model model) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.buyer.name())) {
            long userId = userService.findUserByUserName(userRoleDto.getUserName()).getId();
            List<OrderDto> orderDtoList = orderService.getOrderDtoByState(userId, OrderConst.State.SHOPPINGCART.ordinal());
            model.addAttribute("orderDtoList", orderDtoList);
            model.addAttribute("userRoleDto", userRoleDto);
            return "/order/settleAccount";
        }

        return "redirect:/user/login";
    }

    @RequestMapping(value = "/api/order/payOrder", method = RequestMethod.POST)
    @ResponseBody
    public String payOrder(@RequestParam(value = "id") long id,
                           @RequestParam(value = "amount") int amount) {
        orderService.updateOrderAmountAndState(id, amount, OrderConst.State.PAYED.ordinal());
        JSONObject resultPath = new JSONObject();
        resultPath.put("code", 200);
        return resultPath.toJSONString();
    }

    @RequestMapping(value = "/api/order/cancleOrder", method = RequestMethod.POST)
    @ResponseBody
    public String cancleOrder(@RequestParam(value = "id") long id,
                           @RequestParam(value = "amount") int amount) {
        orderService.updateOrderAmountAndState(id, amount, OrderConst.State.CANCLED.ordinal());
        JSONObject resultPath = new JSONObject();
        resultPath.put("code", 200);
        return resultPath.toJSONString();
    }

    @RequestMapping(value = "/order/account", method = RequestMethod.GET)
    public String accountOrder(Model model) {
        UserRoleDto userRoleDto = UserUtil.getUserRoleDto();
        if(!userRoleDto.getUserName().isEmpty()
                && userRoleDto.getRoleName().equals(UserConst.RoleName.buyer.name())) {
            long userId = userService.findUserByUserName(userRoleDto.getUserName()).getId();
            List<OrderPayedDto> orderPayedDtoList = orderService.getOrderPayedDto(userId);
            BigDecimal totalGoodsPrice = new BigDecimal(0);
            for (OrderPayedDto orderPayedDto : orderPayedDtoList) {
                totalGoodsPrice = totalGoodsPrice.add(orderPayedDto.getTotalPrice());
            }
            model.addAttribute("orderPayedDtoList", orderPayedDtoList);
            model.addAttribute("totalGoodsPrice", totalGoodsPrice);
            model.addAttribute("userRoleDto", userRoleDto);
            return "/order/account";
        }
        return "redirect:/user/login";
    }
}
