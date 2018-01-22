<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里是网站首页
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="/pages/nav.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <iframe src="http://localhost:8088/StuManager/pages/main.jsp" id="myiframe" scrolling="yes" frameborder="0"></iframe>
            </div>
        </div>
    </div>

    <jsp:include page="/pages/bottom.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>

<script>
    function changeIframe(url){
        document.getElementById("myiframe").src=url;
    }
</script>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
<style>
    #myiframe{
        padding: 0;
        margin: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
    }
</style>
</body>
</html>
