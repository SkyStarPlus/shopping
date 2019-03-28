
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ include file="../layouts/application.jsp"%>
<!-- Header -->



<div class="container">

    <div class="card card-login mx-auto mt-5">
        <div class="card-header">登录</div>
        <div class="card-body">
            <form action="<c:url value='/user/login'/>" method="post"
                  class="form-horizontal">

                <div class="form-group">
                    <label >用户名</label>
                    <input type="text" class="form-control" name="userName" />
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input class="form-control" type="password" name="password" />
                </div>
                <input type="submit" value="登录"
                       class="btn btn-primary btn-block" />
            </form>
        </div>
    </div>
</div>

</body>
<%@ include file="../layouts/import_script.jsp"%>
</html>