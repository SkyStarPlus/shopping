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
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col/><col class="num"/><col/><col class="price"/><col/></colgroup>
        <thead>
        <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
            <c:forEach items="${orderPayedDtoList}" var="orderPayedDto" varStatus="status">
                <tr>
                    <td><a href="/goods/show?id=${orderPayedDto.goodsId}"><img src="${orderPayedDto.graphLink}" alt="${orderPayedDto.graphName}"></a></td>
                    <td><h4><a href="/goods/show?id=${orderPayedDto.goodsId}">${orderPayedDto.goodsName}</a></h4></td>
                    <td><span class="v-time">${orderPayedDto.buyTime}</span></td>
                    <td><span class="v-num">${orderPayedDto.amount}</span></td>
                    <td><span class="v-unit">¥</span><span class="value">${orderPayedDto.totalPrice}</span></td>
                </tr>
            </c:forEach>
        </tbody>

        <tfoot>
            <tr>
                <td colspan="4"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">${totalGoodsPrice}</span></td>
            </tr>
        </tfoot>
    </table>
</div>
<div class="n-foot">
    <p>前端页面参考自原Demo项目</p>
</div>
</body>
</html>