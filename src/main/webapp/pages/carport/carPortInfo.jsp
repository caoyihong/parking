<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!-- 包含通用頭 -->
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>基于二维码的停车位引导系统</title>

    <script>
        $(function(){


        });
    </script>
</head>
<body >
<div class="container col-center-block">
    <div class="container">
        <c:if test="${carPortInfo.status == 0}">
            <%--该车位为空，可停车--%>
            <p class="lead">该车位为空，下方输入您的车ID即可停车。</p>
            <form action="${ctx}/car/parking" method="get">
                <input type="hidden" name="carPortId" value="${carPortInfo.id}">
                <input type="text" name="carId" value="1">
                <input type="submit" class="btn btn-success" value="我要停车">
            </form>
        </c:if>
        <c:if test="${carPortInfo.status == 1}">
            <p class="lead">当前车位停靠车辆为：${carPortInfo.carName}</p>
            <p class="lead">停车时间${carPortInfo.arriveTime}</p>
            <p class="lead">总计停车${carPortInfo.duration/60000}分钟，收费${carPortInfo.expense}元</p>
            <a href="${ctx}/car/taking?carPortId=${carPortInfo.id}&carId=${carPortInfo.carId}">我要取车</a>
        </c:if>
    </div>
    <br><br><br><br><br><br>
    <!-- 包含通用尾 -->
    <jsp:include page="../common/footer.jsp" />
</body>

</html>
