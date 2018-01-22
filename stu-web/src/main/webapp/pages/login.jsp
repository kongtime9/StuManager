<%--
  Created by IntelliJ IDEA.
  User: LARK
  Date: 2017/12/4
  Time: 19:47
  To change this template use File | Settings | File Templates.

  这里是登录界面
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body>
<div class="layui-container">

    <div class="layui-row"><!-- 图片开始 -->
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md5" style="margin:0 auto; margin-top: 70px; float: inherit;">

            <!-- 这个div里面可以放一张图片，或者写几个字，随你搞 -->
            <div style="width: 100%; height: 200px;">
                <img src="../images/logo.png" width="100%" height="100%">
            </div>
        </div>
    </div><!-- 图片结束 -->

    <div class="layui-row"><!-- 表单开始 -->
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md5" style="margin:10px auto; float: inherit;">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input type="text" name="uname" lay-verType="tips" required lay-verify="required|username" placeholder="请输入用户名"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="upwd" lay-verType="tips" required lay-verify="required|pass" placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <div class="layui-btn" lay-submit lay-filter="formDemo">登录</div>
                        <!-- 到时候判断登录的用户类型来开启这个添加用户的功能 -->
                        <!-- <a href="http://www.baidu.com" class="layui-btn layui-btn-primary">添加用户</a> -->
                    </div>
                </div>
            </form>
        </div>
    </div><!-- 表单结束 -->

</div>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>--%>
<script>

    /**
     * 加载layui的form组件
     */
    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.jquery;

        form.verify({
            username: function (value, item) { //value：表单的值、item：表单的DOM对象
                if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                    return '用户名不能有特殊字符';
                }
                if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if (/^\d+\d+\d$/.test(value)) {
                    return '用户名不能全为数字';
                }
                if (!/^[\S]{2,50}$/.test(value)) {
                    return '用户名必须2到50位，且不能出现空格';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            , pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
        });

        form.on('submit(formDemo)', function(param){
            $("#msg").removeClass("layui-show").addClass("layui-hide");
            $.ajax({
                url : "${pageContext.request.contextPath}/userController/userLogin",
                data : param.field,
                dataType : "text",
                type : "post",
                timeout : 3000,
                success : function(data){
                    if(data && data == "loginSuccess"){
                        location.href = "${pageContext.request.contextPath}/index.jsp";
                    }else{
                        layer.msg("登录失败！用户名或密码错误！");
                    }
                },
                error : function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg('登录失败！请求超时！服务器繁忙，请稍后重试！');
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
