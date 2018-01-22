<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里是添加班级的页面
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<!-- 内容主体区域 -->
<div style="padding: 15px;">
    <blockquote class="layui-elem-quote">添加班级</blockquote>

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md5" style="margin:30px auto; float: inherit;">
            <form class="layui-form" id="addClsForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">班级名称</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="cname" required lay-verify="required"
                               placeholder="请输入班级名称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开班时间</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="classBegin" readonly required lay-verify="required"
                               placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" id="date">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">班级口号</label>
                    <div class="layui-input-block">
                        <textarea name="cslogan" placeholder="请输入班级口号" class="layui-textarea"
                                  style="height: 150px"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="text-align: right">
                        <div class="layui-btn" lay-submit lay-filter="formDemo">确认添加</div>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'laydate', 'form'], function () {
        var element = layui.element;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var form = layui.form;

        //执行一个laydate实例
        laydate.render({
            elem: '#date', //指定元素
            max: 0,
            theme: 'molv',
            showBottom: false,
            trigger: 'click'
        });

        //监听提交
        form.on('submit(formDemo)', function (param) {
            $.ajax({
                url: "${pageContext.request.contextPath}/clsController/addCls",
                data: param.field,
                dataType: "text",
                type: "post",
                timeout: 3000,
                success: function (data) {
                    if (data && data == "addClsSuccess") {
                        layer.msg("添加成功！");
                        $("#addClsForm")[0].reset();
                    } else {
                        layer.msg("添加失败！");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg("添加失败失败！请求超时！服务器繁忙，请稍后重试！");
                }
            });
            return false;
        });

    });
</script>
</body>
</html>
