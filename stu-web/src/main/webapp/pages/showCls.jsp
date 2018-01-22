<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里显示班级信息
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<!-- 内容主体区域 -->
<div style="padding: 15px;">
    <blockquote class="layui-elem-quote">班级信息</blockquote>


    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table id="clsTable" class="layui-hide" lay-filter="clsTable"></table>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#clsTable'
            , height: 'full-112',
            cellMinWidth: 80
            , url: '${pageContext.request.contextPath}/clsController/findClsList' //数据接口
            , page: true //开启分页
            , cols: [[
                {type: 'numbers'}
                , {type: 'checkbox', field: 'cno'}
                , {field: 'cname', width: 100, title: '班级名称', sort: true}
                , {field: 'classBegin', width: 135, title: '开班时间', sort: true}
                , {field: 'cslogan', width: 320, title: '班级口号'}
            ]],
            initSort: {field: 'cname', type: 'asc'}
        });

    });
</script>
</body>
</html>
