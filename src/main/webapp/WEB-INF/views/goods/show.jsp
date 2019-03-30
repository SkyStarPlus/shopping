<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="../../../resources/css/style.css"/>
</head>

<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div>

<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${goods.graphLink}" alt="${goods.graphName}" ></div>
        <div class="cnt">
            <h2>${goods.name}</h2>
            <p class="summary">${goods.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${goods.price}</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">0</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <button class="u-btn u-btn-primary" id="add" data-id="${goods.id}" data-title="${goods.name}" data-price="${goods.price}">
                    加入购物车</button>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${goods.description}
    </div>
</div>
<div class="n-foot">
    <p>前端页面参考自原Demo项目</p>
</div><script type="text/javascript" src="../../../resources/js/global.js"></script>
<script type="text/javascript" src="../../../resources/js/pageShow.js"></script>
</body>
</html>