
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<a class="navbar-brand" href="#">智能业务过程管理平台</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Dashboard"><a class="nav-link"
				href="<c:url value="/package/all" />"> <i class="fa fa-fw fa-dashboard"></i>
					<span class="nav-link-text"> 我的主页</span>
			</a></li>

			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link"
				href="<c:url value="/task/all" />"> <i class="fa fa-fw fa-table"></i>
					<span class="nav-link-text"> 任务列表</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Menu Levels"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseMulti" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">
						包</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseMulti">
					<li><a href="<c:url value="/package/new" />">新建包</a></li>
					<li><a href="<c:url value="/package/all" />">我具有权限的包</a></li>
					<li><a class="nav-link-collapse collapsed"
						data-toggle="collapse" href="#collapseMulti2">其他</a>
						<ul class="sidenav-third-level collapse" id="collapseMulti2">
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
						</ul></li>
				</ul></li>
				
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Monitor"><a class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseMulti3" data-parent="#exampleAccordion">
				<i class="fa fa-fw fa-table"></i>
					<span class="nav-link-text"> 流程监控</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseMulti3">
					<li><a href="<c:url value="/monitor/all" />">流程实例</a></li>
					<li><a href="<c:url value="/statistic/all" />">工作流执行统计</a></li>
				</ul>
			</li>
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Charts"><a class="nav-link" href="#"> <i
					class="fa fa-fw fa-area-chart"></i> <span class="nav-link-text">
						设置</span>
			</a></li>
		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-lg-2" href="#"
				id="messagesDropdown" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-fw fa-envelope"></i> <span
					class="d-lg-none">Messages <span
						class="badge badge-pill badge-primary">New</span>
				</span> <span class="new-indicator text-primary d-none d-lg-block">
						<i class="fa fa-fw fa-circle"></i>
				</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="messagesDropdown">
					<h6 class="dropdown-header">New Messages:</h6>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>David
							Miller</strong> <span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">Hey there! This new
							version of SB Admin is pretty awesome! These messages clip off
							when they reach the end of the box so they don't overflow over to
							the sides!</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>Jane Smith</strong>
						<span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">I was wondering if you
							could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>John Doe</strong> <span
						class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">I've sent the final
							files over to you for review. When you're able to sign off of
							them let me know and we can discuss distribution.</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item small" href="#"> View all messages </a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-lg-2" href="#"
				id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-fw fa-bell"></i> <span
					class="d-lg-none">Alerts <span
						class="badge badge-pill badge-warning">New</span>
				</span> <span class="new-indicator text-warning d-none d-lg-block">
						<i class="fa fa-fw fa-circle"></i>
				</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="alertsDropdown">
					<h6 class="dropdown-header">New Alerts:</h6>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <span class="text-success">
							<strong> <i class="fa fa-long-arrow-up"></i> Status
								Update
						</strong>
					</span> <span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">This is an automated
							server response message. All systems are online.</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <span class="text-danger">
							<strong> <i class="fa fa-long-arrow-down"></i> Status
								Update
						</strong>
					</span> <span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">This is an automated
							server response message. All systems are online.</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <span class="text-success">
							<strong> <i class="fa fa-long-arrow-up"></i> Status
								Update
						</strong>
					</span> <span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">This is an automated
							server response message. All systems are online.</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item small" href="#"> View all alerts </a>
				</div></li>
			<li class="nav-item">
				<form class="form-inline my-2 my-lg-0 mr-lg-2">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</li>
			<shiro:guest>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/user/login"/>"> <i
						class="fa fa-fw fa-sign-in"></i> Login
				</a></li>
			</shiro:guest>
			<shiro:user>
				<li class="nav-item">
				    <a class="nav-link" href="#"> 
				        <shiro:principal type="java.lang.String" />
					</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/user/logout"/>"> <i
						class="fa fa-fw fa-sign-out"></i> Logout
				</a></li>
			</shiro:user>
		</ul>
	</div>
</nav>
