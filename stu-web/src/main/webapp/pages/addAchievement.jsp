<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里是添加成绩的页面
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Achievement</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 这里引入导航条 -->
    <jsp:include page="/pages/nav.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">添加成绩</blockquote>

            其他内容自己搞

        </div>
    </div>

    <!-- 这里引入固定底部 -->
    <jsp:include page="/pages/bottom.jsp"/>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
