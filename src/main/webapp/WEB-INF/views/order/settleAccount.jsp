<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
            买家你好，<span class="name">buyer</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/account">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
        </ul>
    </div>
</div>

<div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
        <h2>已添加到购物车的内容</h2>
    </div>

    <table id="newTable" class="m-table m-table-row n-table g-b3">
        <tr>
            <th>内容名称</th>
            <th>数量</th>
            <th>单价</th>
            <th>总价格</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${orderDtoList}" var="orderDto" varStatus="status">
            <tr id="order-${orderDto.id}">
                <td>${orderDto.goodsName}</td>
                <td><span class="lessNum">-</span>
                    <span class="totalNum" id="allNum">${orderDto.amount}</span>
                    <span id="thisId">${orderDto.goodsId}</span>
                    <span class="moreNum">+</span>
                </td>
                <td>${orderDto.price}</td>
                <td>${orderDto.totalPrice}</td>
                <td>
                    <div id="act-btn-pay-${orderDto.id}">
                        <button class="u-btn u-btn-primary" value="pay" data-id="${orderDto.id}">购买</button>
                    </div>
                </td>
                <td>
                    <div id="act-btn-cancle-${orderDto.id}">
                        <button class="u-btn u-btn-primary" value="cancle" data-id="${orderDto.id}">移除</button>
                    </div>
                </td>
            </tr>
        </c:forEach>

    </table>

    <div id="act-btn">
        <button class="u-btn u-btn-primary" id="back">退出</button>
        <%--<button class="u-btn u-btn-primary" id="Account">购买</button>--%>
    </div>
</div>


<div class="n-foot">
    <p>前端页面参考自原Demo项目</p>
</div>

<script type="text/javascript" src="../../../resources/js/global.js"></script>
<script type="text/javascript" src="../../../resources/js/settleAccount.js"></script>
</body>
</html>