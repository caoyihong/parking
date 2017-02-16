<!doctype html>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${ctx}/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" >
        <link href="${ctx}/static/css/common.css" rel="stylesheet" >
        <script src="${ctx}/static//bootstrap/js/jquery-1.7.2.min.js"></script>
        <script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
    </head>
</html>