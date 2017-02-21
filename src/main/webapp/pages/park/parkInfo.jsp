<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!-- 包含通用頭 -->
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>基于二维码的停车位引导系统</title>
</head>
<body >
<div class="container col-center-block">

    <div class="row">
        <div class="col-xs-2"><span class="glyphicon glyphicon-ok-circle btn-danger">车位1</span> </div>
        <div class="col-xs-2">车位2</div>
        <div class="col-xs-2">车位3</div>
        <div class="col-xs-2">车位4</div>
        <div class="col-xs-2"><span class="glyphicon glyphicon-ok-circle btn-danger">车位5</span></div>
    </div>
</div>
<br><br><br><br><br><br>
<!-- 包含通用尾 -->
<jsp:include page="../common/footer.jsp" />
</body>
<%--<script>--%>
    <%--$(function () {--%>
        <%--alert("aa");--%>
    <%--});--%>
<%--</script>--%>
</html>
