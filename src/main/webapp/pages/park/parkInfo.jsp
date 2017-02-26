<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!-- 包含通用頭 -->
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>基于二维码的停车位引导系统</title>
    <style>
        .container{
            width: 1000px;
            margin: 0 auto;
        }
        .content-div{
            position: relative;
        }
        .eg-div{
            width: 120px;
            height: 50px;
            margin:20px 34px;
            float: left;
        }
        .circle {
            width: 30px;
            height: 30px;
            margin-left: 440px;
            margin-top: 150px;
            background: red;
            -moz-border-radius: 50px;
            -webkit-border-radius: 50px;
            border-radius: 50px;
        }
        #canvas{
            position: absolute;
            left: 0;
            top: 0;
            z-index: -1;
        }
        .green{
            background: #00CD00;
        }
        .red{
            background: #CD0000;
        }
    </style>
    <script>
        $(function(){
            var canvas = document.getElementById("canvas");//获取到canvas元素
            var context = canvas.getContext("2d");//获取上下文的环境
            var allstarts=[]; //保存已连线的坐标
            var hasstarts;    //标志是否已连线

            $(".eg-div").click(function(){
                var index=$(".eg-div").index(this)+1;
                var startx=getCoordinate(index).x; //横坐标
                var starty=getCoordinate(index).y; //纵坐标
                context.beginPath();
                context.moveTo(startx,starty); //起点坐标
                context.lineTo(455,525); //得到的终点坐标
                context.save(); //保存环境状态已便重绘
                if(instarts(startx,starty)){ //判断连线是否存在
                    context.lineWidth = 5;//线条的宽度
                    context.strokeStyle = "white";//线条的颜色
                    context.fillStyle = "white";//隐藏为白色

                }else{
                    allstarts.push([startx,starty]);
                    context.lineWidth = 2;//线条的宽度 可调
                    context.strokeStyle = "#333";//线条的颜色 可调
                }
                context.stroke();//绘制
                context.restore();//返回环境状态已便重绘


            });

            function instarts(x,y){
                hasstarts=false;
                for(var i=0;i<allstarts.length;i++){
                    console.log(allstarts[i][0]);
                    console.log(allstarts[i][1]);
                    if(allstarts[i][0]==x&allstarts[i][1]==y){
                        hasstarts=true;
                        allstarts.splice(i,1); //去掉坐标
                    }
                }
                return hasstarts;
            }


            function getCoordinate(index){ //得到坐标
                var div=$(".eg-div");
                var width=div.css("width").replace('px', '');
                var height=div.css("height").replace('px', '');
                var top=div.css("margin-top").replace('px', '');
                var left=div.css("margin-left").replace('px', '');
                var widthdiv=parseInt(width)+parseInt(left*2);
                var hightdiv=parseInt(height)+parseInt(top*2);
                var x=parseInt(width/2)+parseInt(left);
                var y=parseInt(height)+parseInt(top);
                var xs;
                var ys;
                var column=parseInt(index/5); //列
                var row=parseInt(index%5); //行
                if(row==0){
                    row=5;
                    column=column-1;
                }
                xs=row*widthdiv-x;
                ys=column*hightdiv+y;
                return {
                    x: xs,
                    y: ys
                };
            }
        })

    </script>
</head>
<body >
<div class="container col-center-block">
    <div class="container">
        <blockquote>
            <p>${parkInfo.park.parkName}</p>
            <mark>${parkInfo.park.info}</mark>
        </blockquote>
        此停车场共有<strong>${parkInfo.park.parkNum}</strong>个车位
        <div class="content-div">
            <div class="list-div">
                <c:forEach items="${parkInfo.carports}" var="carport">
                    <c:if test="${carport.status == 0}">
                        <div class="eg-div green">${carport.info}</div>
                    </c:if>
                    <c:if test="${carport.status == 1}">
                        <div class="eg-div red">${carport.info}</div>
                    </c:if>
                </c:forEach>

                <div style="clear: both"></div>
            </div>
            <div class="end-div">
                <div class="circle" data-left="440" data-top="525"></div>
            </div>
            <canvas id="canvas" width="940px" height="600px">当前浏览器不支持canvas，请更换浏览器使用！</canvas>
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
