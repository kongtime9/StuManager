<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里显示学生信息
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<!-- 内容主体区域 -->
<div style="padding: 15px;">
    <blockquote class="layui-elem-quote">学生信息</blockquote>

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="search">
                <div class="layui-inline">
                    <input class="layui-input" name="keyWord" id="keyWord" placeholder="输入班级/学号/姓名" autocomplete="off">
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
            <table id="stuTable" class="layui-hide" lay-filter="stuTable" ></table>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'table','form'], function () {
        var element = layui.element;
        var table = layui.table;
        var form = layui.form;

        var stuTable = table.render({
            elem: '#stuTable'
            , height: 'full-150'
            , cellMinWidth: 80
            , url: '${pageContext.request.contextPath}/stuController/findStuList' //数据接口
            , page: true //开启分页
            , cols: [[
                {type: 'numbers'}
                , {field: 'cname', width: 80, title: '班级', sort: true, templet: '#showCls'}
                , {field: 'sno', width: 80, title: '学号', sort: true, templet: '<span>{{d.data.stu.sno}}</span>'}
                , {field: 'simage', width: 100, title: '图片', templet: '#showImage', align: 'center'}
                , {field: 'sname', width: 100, title: '学生姓名', sort: true, templet: '<div>{{d.data.stu.sname}}</div>'}
                , {
                    field: 'sage',
                    width: 80,
                    title: '年龄',
                    sort: true,
                    align: 'center',
                    templet: '<span>{{d.data.stu.sage}}</span>'
                }
                , {field: 'ssex', width: 80, title: '性别', sort: true, templet: '#chageSex', align: 'center'}
                , {
                    field: 'saddress',
                    width: 120,
                    title: '地址',
                    sort: true,
                    templet: '<span>{{d.data.stu.saddress}}</span>'
                }
                , {field: 'stel', width: 130, title: '电话', templet: '<span>{{d.data.stu.stel}}</span>'}
                , {
                    field: 'senrolmenttime',
                    width: 115,
                    title: '入学时间',
                    sort: true,
                    templet: '<span>{{d.data.stu.senrolmenttime}}</span>'
                },
                {
                    fixed: 'right',
                    width:100,
                    align:'center',
                    toolbar: '#toolBar'}
            ]]
            , initSort: {field: 'sno', type: 'asc'}
            , id: 'StuTab'
        });


        //监听工具条
        table.on('tool(stuTable)', function(obj){
            var data = obj.data.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    console.log(data.stu);
                    $.post("${pageContext.request.contextPath}/stuController/deleteStu", "sno=" + data.stu.sno, function (res) {
                        stuTable.reload({
                            data: res
                        });
                    });
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                console.log(data);
                    var updateForm = `<form class="layui-form" id="updateStuForm">
                    <input type="hidden" name="sno" value="`+ data.stu.sno +`">
                    <div class="layui-form-item">
                        <label class="layui-form-label">学生图像</label>
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="stuImage">选择图像</button>
                            <input type="hidden" name="simage" value="`+ data.stu.simage +`"/>
                            <div style="margin-top: 10px;text-align: center;width: 318px">
                                <img class="layui-upload-img"
                                     src="${pageContext.request.contextPath}/images/user.jpg" id="showImage"
                                     width="100" height="100">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">学生姓名</label>
                        <div class="layui-input-block">
                            <input type="text" value="`+ data.stu.sname +`" lay-verType="tips" name="sname" required
                                   lay-verify="required" placeholder="请输入学生姓名" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">年龄</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verType="tips" value="`+ data.stu.sage +`" name="sage" required
                                   lay-verify="required|number" placeholder="请输入年龄" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="ssex" value="1" title="男">
                            <input type="radio" name="ssex" value="0" title="女">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">家庭住址</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verType="tips" value="`+ data.stu.saddress +`" name="saddress" required
                                   lay-verify="required" placeholder="请输入学生住址" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verType="tips" value="`+ data.stu.stel +`" name="stel" required
                                   lay-verify="required|phone" placeholder="请输入联系方式" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">入学时间</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verType="tips" value="`+ data.stu.senrolmenttime +`" name="senrolmenttime" readonly
                                   required lay-verify="required" placeholder="yyyy-MM-dd" autocomplete="off"
                                   class="layui-input" id="date">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">请选择班级</label>
                        <div class="layui-input-block">
                            <select name="cls.cno" lay-verType="tips" lay-verify="required">
                                <option value=""></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="text-align: right">
                            <div class="layui-btn" lay-submit lay-filter="updateForm">确认添加</div>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>`;
                layer.open({
                    type: 1,
                    title: '修改學生',
                    content: updateForm,
                    area:['400px','400px']
                });

                data.stu.ssex == 1 ? $("input[name='ssex']")[0].checked = true : $("input[name='ssex']")[1].checked = true

                $.ajax({
                    url: '${pageContext.request.contextPath}/stuController/findClsList',
                    data: data.cls,
                    type: 'post',
                    success:function(res){
                        $.each(res, function(i,v){
                            $("select[name='cls.cno']").append("<option value='"+ v.cno +"'>"+ v.cname +"</option>");
                        });

                        $("select").val(data.cls.cno);

                        form.render();
                    }
                });

            }

        });

        <!--更新-->
        form.on("submit(updateForm)",function(param){
            console.log(param)
            $.ajax({
                url: "${pageContext.request.contextPath}/stuController/updateStu",
                data: param.field,
                //dataType : "text",
                type: "POST",
                timeout: 3000,
                success: function (res) {
                    if (res && res != "updateStuFail") {
                        console.log(res)
                        $("#updateStuForm")[0].reset();
                        $('#showImage').attr('src', '${pageContext.request.contextPath}/images/user.jpg');
                        layer.closeAll();

                        stuTable.reload({
                            data: res
                        });
                    } else {
                        layer.msg("修改失败！");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg("修改失败！请求超时！服务器繁忙，请稍后重试！");
                }
            });
            return false;
        });


        var $ = layui.$, active = {
            reload: function () {
                var keyWord = $('#keyWord');

                //执行重载
                table.reload('StuTab', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        keyword: keyWord.val()
                    }
                });
            }
        };

        $('.search .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>

<!-- 添加工具欄 -->
<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script type="text/html" id="chageSex">
    {{d.data.stu.ssex == 1? '男':'女'}}
</script>

<script type="text/html" id="showCls">
    {{d.data.cls.cname}}
</script>
<script type="text/html" id="showImage">
    <img src="${pageContext.request.contextPath}/images/{{d.data.stu.simage}}" width="50" height="50"/>
</script>
<style>
    .layui-table-cell {
        height: 50px;
        line-height: 50px;
    }

    .laytable-cell-1-sno {
        padding-top: 5px;
    }
</style>
</body>
