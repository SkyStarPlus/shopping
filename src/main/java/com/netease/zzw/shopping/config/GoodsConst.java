package com.netease.zzw.shopping.config;

public class GoodsConst {
    public static final String relativePath = "/images/";

    public enum GraphSource {
        url, file;
    }

    public enum GoodsIndexShowState {
        NO_BUY, SHOPPING_CART, PAYED, UNSOLD, SOLD, NO_LOGIN;
    }

//    public static void main(String[] args) {
//        boolean flag = GraphSource.url.name().equals("url");
//        System.out.println(flag);
//
//        System.out.println(GoodsIndexShowState.NO_BUY.ordinal());
//    }
}
