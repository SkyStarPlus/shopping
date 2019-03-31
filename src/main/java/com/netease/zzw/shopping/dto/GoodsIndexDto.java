package com.netease.zzw.shopping.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsIndexDto implements Serializable {
    private long id;
    private String name;
    private BigDecimal price;
    private String graphName;
    private String graphLink;
    private int state;

    public GoodsIndexDto() {
    }

    public GoodsIndexDto(long id, String name, BigDecimal price, String graphName, String graphLink, int state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.graphName = graphName;
        this.graphLink = graphLink;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
