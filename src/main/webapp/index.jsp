<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!-- 包含通用頭 -->
<%@ include file="./pages/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>基于二维码的停车位引导系统</title>
</head>
<body>
<div class="container">
<h2>基于二维码的停车位引导系统</h2>
<br/><br/><br/>
<a href="${ctx}/code/parkcode">下载车库二维码</a>
<br><br><br><br>
<form action="localhost:8080/code/carport" method="get">
    <b>请输入指定停车位，过去对应的二维码</b>
    <input type="text" name="carportno" placeholder="1">
    <input type="submit" value="确定">
</form>
</div>
<!-- 包含通用尾 -->
<jsp:include page="./pages/common/footer.jsp" />
</body>
</html>
