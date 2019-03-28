<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta http-equiv="nocache" content="no-cache">
	
	<title>Supertex</title>
	
	<s:url value="/resources/stylesheet/bootstrap.min.css" var="bootstrapCss" />
    <s:url value="/resources/stylesheet/font-awesome.min.css" var="fontAwesomeCss" />
    <s:url value="/resources/stylesheet/dataTables.bootstrap4.css" var="dataTablesBootstrap4Css" />
    <s:url value="/resources/stylesheet/sb-admin.css" var="sbAdminCss" />
    <s:url value="/resources/stylesheet/bootstrap-tagsinput.css" var="bootstrapTagsinputCss" />
    <s:url value="/resources/stylesheet/formbuilder.css" var="formbuilderCss" />
    <s:url value="/resources/stylesheet/jquery.rateyo.min.css" var="jqueryRateyoMinCss" />
    <s:url value="/resources/stylesheet/bs-is-fun.css" var="bsIsFunCss" />  
    <s:url value="/resources/stylesheet/bootstrap-table.min.css" var="bootstrapTableCss" />   
    <s:url value="/resources/stylesheet/bootstrap-table-filter-control.css" var="bootstrapTableFilterControlCss" />   
    <s:url value="/resources/stylesheet/frappe-gantt.css" var="frappeGanttCss" />   
    
    
    <link rel="stylesheet" media="all" href="${bsIsFunCss}"/>
    <link rel="stylesheet" media="all" href="${bootstrapCss}"/>
    <link rel="stylesheet" media="all" href="${fontAwesomeCss}"/>
    <link rel="stylesheet" media="all" href="${dataTablesBootstrap4Css}"/> 
    <link rel="stylesheet" media="all" href="${sbAdminCss}"/>
	<link rel="stylesheet" media="all" href="${bootstrapTagsinputCss}"/>
    <link rel="stylesheet" media="all" href="${jqueryRateyoMinCss}"/>
    <link rel="stylesheet" media="all" href="${formbuilderCss}"/>
    <link rel="stylesheet" media="all" href="${bootstrapTableCss}"/>
    <link rel="stylesheet" media="all" href="${bootstrapTableFilterControlCss}"/>
    <link rel="stylesheet" media="all" href="${frappeGanttCss}"/>
    
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

