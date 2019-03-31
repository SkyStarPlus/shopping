package com.netease.zzw.shopping.service;

import com.netease.zzw.shopping.config.GoodsConst;
import com.netease.zzw.shopping.config.OrderConst;
import com.netease.zzw.shopping.config.UserConst;
import com.netease.zzw.shopping.dao.GoodsDao;
import com.netease.zzw.shopping.dao.OrderDao;
import com.netease.zzw.shopping.dao.UserDao;
import com.netease.zzw.shopping.dto.GoodsIndexDto;
import com.netease.zzw.shopping.model.Goods;
import com.netease.zzw.shopping.model.Order;
import com.netease.zzw.shopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addGoods(String name, long publisherId, BigDecimal price, String summary, String description,
                         String graphName, String graphSource, String graphLink) {
        goodsDao.addGoods(name, publisherId, price, summary, description, graphName, graphSource, graphLink);
    }

    @Override
    public void updateGoodsById(long id, String name, long publisherId, BigDecimal price, String summary, String description, String graphName, String graphSource, String graphLink) {
        goodsDao.updateGoodsById(id, name, publisherId, price, summary, description, graphName, graphSource, graphLink);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.findAll();
    }

    @Override
    public Goods getGoodsById(long id) {
        return goodsDao.findById(id);
    }

    @Override
    public int deleteGoodsById(long id) {
        return goodsDao.deleteById(id);
    }

    @Override
    public List<GoodsIndexDto> getGoodsIndexShowDto(String userName, String roleName, int type) {
        List<GoodsIndexDto> goodsIndexDtoList = new ArrayList<>();

        // no login
        if(userName.equals("") || userName.isEmpty()) {
            List<Goods> goodsList = goodsDao.findAll();
            for(Goods goods : goodsList) {
                GoodsIndexDto goodsIndexDto = new GoodsIndexDto(
                        goods.getId(),
                        goods.getName(),
                        goods.getPrice(),
                        goods.getGraphName(),
                        goods.getGraphLink(),
                        GoodsConst.GoodsIndexShowState.NO_LOGIN.ordinal()
                );
                goodsIndexDtoList.add(goodsIndexDto);
            }

            return goodsIndexDtoList;
        }

        User user = userDao.findByUserName(userName);
        // seller
        if(roleName.equals(UserConst.RoleName.seller.name())) {
            List<Goods> goodsList = goodsDao.findByPublisherId(user.getId());

            if(!goodsList.isEmpty()) {
                List<Long> goodsIdList = new ArrayList<>();
                for(Goods goods : goodsList) {
                    goodsIdList.add(goods.getId());
                }

                List<Order> orderList = orderDao.findOrdersByGoodsId(goodsIdList);
                for(Goods goods : goodsList) {

                    int state = GoodsConst.GoodsIndexShowState.UNSOLD.ordinal();
                    for(Order order : orderList) {
                        if(order.getGoodsId() == goods.getId()) {
                            state = GoodsConst.GoodsIndexShowState.SOLD.ordinal();
                            break;
                        }
                    }

                    GoodsIndexDto goodsIndexDto = new GoodsIndexDto(
                            goods.getId(),
                            goods.getName(),
                            goods.getPrice(),
                            goods.getGraphName(),
                            goods.getGraphLink(),
                            state
                    );

                    goodsIndexDtoList.add(goodsIndexDto);
                }
            }
            // buyer
        } else if(roleName.equals(UserConst.RoleName.buyer.name())) {
            List<Goods> goodsList = goodsDao.findAll();

            if(!goodsList.isEmpty()) {
                List<Order> orderList = orderDao.findOrdersByUserId(user.getId());
                for(Goods goods : goodsList) {
                    int state = GoodsConst.GoodsIndexShowState.NO_BUY.ordinal();
                    for(Order order : orderList) {
                        if(order.getGoodsId() == goods.getId()) {
                            if(order.getState() == OrderConst.State.PAYED.ordinal()) {
                                state = GoodsConst.GoodsIndexShowState.PAYED.ordinal();
                                break;
                            } else if(order.getState() == OrderConst.State.SHOPPINGCART.ordinal()) {
                                state = GoodsConst.GoodsIndexShowState.SHOPPING_CART.ordinal();
                            }
                        }
                    }

                    GoodsIndexDto goodsIndexDto = new GoodsIndexDto(
                            goods.getId(),
                            goods.getName(),
                            goods.getPrice(),
                            goods.getGraphName(),
                            goods.getGraphLink(),
                            state
                    );

                    // 已购买加未购买
                    if(type == 0) {
                        goodsIndexDtoList.add(goodsIndexDto);
                        // 未购买
                    } else if(type == 1 && state == GoodsConst.GoodsIndexShowState.NO_BUY.ordinal()) {
                        goodsIndexDtoList.add(goodsIndexDto);
                    }
                }
            }
        }
        return goodsIndexDtoList;
    }

    @Override
    public int getGoodsUserBuyedAmount(long userId, long goodsId) {
        Order order = orderDao.findOrderByUserIdAAndGoodsId(userId, goodsId);
        if(order != null) {
            return order.getAmount();
        }
        return -1;
    }

    @Override
    public long getAllBuyGoodsAmount(long goodsId) {
        List<Order> orderList = orderDao.findOrdersByGoodsId(goodsId);
        if(orderList.isEmpty()) {
            return -1;
        }


        long sum = 0;
        for(Order order : orderList) {
            sum += order.getAmount();
        }
        return sum;
    }
}
