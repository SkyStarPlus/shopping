package com.netease.zzw.shopping.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayedDto implements Serializable {
    private long id;
    private long userId;
    private long goodsId;
    private String goodsName;
    private String graphName;
    private String graphLink;
    private Date buyTime;
    private int amount;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public OrderPayedDto() {
    }

    public OrderPayedDto(long id, long userId, long goodsId, String goodsName, String graphName, String graphLink, Date buyTime, int amount, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.graphName = graphName;
        this.graphLink = graphLink;
        this.buyTime = buyTime;
        this.amount = amount;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGraphName() {
        return graphName;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public String getGraphLink() {
        return graphLink;
    }

    public void setGraphLink(String graphLink) {
        this.graphLink = graphLink;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
