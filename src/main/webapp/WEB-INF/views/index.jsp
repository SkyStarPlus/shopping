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
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            <c:if test='${userRoleDto.roleName==""}'>
                请<a href="/user/login">[登录]</a>
            </c:if>

            <c:if test='${userRoleDto.roleName!=""}'>
                ${userRoleDto.displayRoleName}你好，<span class="name">${userRoleDto.userName}</span>！<a href="/user/logout">[退出]</a>
            </c:if>
        </div>


        <ul class="nav">
            <li><a href="/">首页</a></li>
            <c:if test='${userRoleDto.roleName=="seller"}'>
                <li><a href="/goods/public">发布</a></li>
            </c:if>

            <c:if test='${userRoleDto.roleName=="buyer"}'>
                <li><a href="/order/account">账务</a></li>
            </c:if>
            <c:if test='${userRoleDto.roleName=="buyer"}'>
                <li><a href="/order/settleAccount">购物车</a></li>
            </c:if>
        </ul>
    </div>
</div>

<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel" ><a href="/">所有内容</a></li>
                <c:if test='${userRoleDto.roleName=="buyer"}'>
                    <li><a href="/?type=1">未购买的内容</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:forEach items="${goodsList}" var="goods" varStatus="status">
                <li id="p-${goods.id}">
                    <a href="/goods/show?id=${goods.id}" class="link">
                        <div class="img"><img src="${goods.graphLink}" alt="${goods.graphName}"></div>
                        <h3>${goods.name}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${goods.price}</span></div>

                        <c:if test='${goods.state==1}'>
                            <span class="had"><b>购物车内</b></span>
                        </c:if>

                        <c:if test='${goods.state==2}'>
                            <span class="had"><b>已购买</b></span>
                        </c:if>

                        <c:if test='${goods.state==4}'>
                            <span class="had"><b>已售出</b></span>
                        </c:if>
                    </a>

                    <c:if test='${goods.state==3}'>
                        <span class="u-btn u-btn-normal u-btn-xs del" data-del="${goods.id}">删除</span>
                    </c:if>
                </li>
            </c:forEach>

        </ul>
    </div>
</div>
<div class="n-foot">
    <p>前端页面参考自原Demo项目</p>
</div><script type="text/javascript" src="../../resources/js/global.js"></script>
<script type="text/javascript" src="../../resources/js/pageIndex.js"></script>
</body>
</html>
