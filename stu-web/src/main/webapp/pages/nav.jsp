<%--
  Created by IntelliJ IDEA.
  User: LARK
  Date: 2017/12/7
  Time: 9:16
  To change this template use File | Settings | File Templates.

  这里是侧边导航栏和顶部导航栏
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="layui-header">
    <div class="layui-logo">学生管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="${pageContext.request.contextPath}/images/user.jpg" class="layui-nav-img">
                ${login_user.uname}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">安全设置</a></dd>
                <dd><a href="${pageContext.request.contextPath}/userController/exitLogin">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-this">
                <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">学生管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" onclick="changeIframe('${pageContext.request.contextPath}/pages/addStu.jsp')">添加学生</a></dd>
                    <dd><a href="javascript:;" onclick="changeIframe('${pageContext.request.contextPath}/pages/showStu.jsp')">学生信息</a></dd>
                </dl>
            </li>
            <%--
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">成绩管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/pages/addAchievement.jsp">添加成绩</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/pages/showAchievement.jsp">成绩信息</a></dd>
                </dl>
            </li>
            --%>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">班级管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" onclick="changeIframe('${pageContext.request.contextPath}/pages/addCls.jsp')">添加班级</a></dd>
                    <dd><a href="javascript:;" onclick="changeIframe('${pageContext.request.contextPath}/pages/showCls.jsp')">班级信息</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
