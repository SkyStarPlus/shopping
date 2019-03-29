<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="../../../resources/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel" ><a href="/">所有内容</a></li>

            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:forEach items="${goodsList}" var="goods" varStatus="status">
                <li id="p-${goods.id}">
                    <a href="/goods/show?id=${goods.id}" class="link">
                        <div class="img"><img src="${goods.graphLink}" alt="${goods.graphName}"></div>
                        <h3>${goods.summary}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${goods.price}</span></div>
                    </a>
                    <span class="u-btn u-btn-normal u-btn-xs del" data-del="262">删除</span>
                </li>
            </c:forEach>

            <li id="p-1">
                <a href="/show?id=1" class="link">
                    <div class="img"><img src="https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=78123d3cc21b9d169eca923392b7dfea/a71ea8d3fd1f413499deaa9d291f95cad0c85e63.jpg" alt="SICPP"></div>
                    <h3>SICPP</h3>
                    <div class="price"><span class="v-unit">¥</span><span class="v-value">-234.11</span></div>
                </a>
            </li>

        </ul>
    </div>
</div>
<div class="n-foot">
    <p>前端页面参考自原Demo项目</p>
</div><script type="text/javascript" src="../../resources/js/global.js"></script>
<script type="text/javascript" src="../../resources/js/pageIndex.js"></script>
</body>
</html>
