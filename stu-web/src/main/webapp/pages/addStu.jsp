<%--
  Created by IntelliJ IDEA.
  User: qixuan
  Date: 2017/12/6
  Time: 19:26
  To change this template use File | Settings | File Templates.

  这里是添加学生的页面
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<div style="padding: 15px;">
    <blockquote class="layui-elem-quote">添加学生</blockquote>

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md5" style="margin:30px auto; float: inherit;">
            <form class="layui-form" id="addStuForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">学生图像</label>
                    <div class="layui-upload">
                        <button type="button" class="layui-btn" id="stuImage">选择图像</button>
                        <input type="hidden" name="simage"/>
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
                        <input type="text" lay-verType="tips" name="sname" required
                               lay-verify="required" placeholder="请输入学生姓名" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="sage" required
                               lay-verify="required|number" placeholder="请输入年龄" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" name="ssex" value="1" title="男" checked>
                        <input type="radio" name="ssex" value="0" title="女">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">家庭住址</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="saddress" required
                               lay-verify="required" placeholder="请输入学生住址" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="stel" required
                               lay-verify="required|phone" placeholder="请输入联系方式" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">入学时间</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verType="tips" name="senrolmenttime" readonly
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
                        <div class="layui-btn" lay-submit lay-filter="formDemo">确认添加</div>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'laydate', 'form', 'upload'], function () {
        var element = layui.element;
        var laydate = layui.laydate;
        var form = layui.form;
        var upload = layui.upload;
        upload.render({
            elem: '#stuImage'
            , url: '${pageContext.request.contextPath}/stuController/upLoadFile'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#showImage').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                console.log(res.fileName);
                $("input[name='simage']").val(res.fileName);

            }
        });


        //执行一个laydate实例
        laydate.render({
            elem: '#date', //指定元素
            max: 0,
            theme: 'molv',
            showBottom: false,
            trigger: 'click'
        });

        //form验证
        form.verify({
            number: function (value, item) {
                try {
                    value = parseInt(value);
                    if (!(typeof value === "number" && value >= 6 && value <= 60)) {
                        return '年龄必须为6到60之间的数字';
                    }
                } catch (e) {
                    return '年龄必须为6到60之间的数字';
                }
            }
        });

        //监听提交
        form.on('submit(formDemo)', function (param) {
            console.log(param.field);
            $.ajax({
                url: "${pageContext.request.contextPath}/stuController/addStu",
                data: param.field,
                //dataType : "text",
                type: "POST",
                timeout: 3000,
                success: function (data) {
                    if (data && data == "addStuSuccess") {
                        layer.msg("添加成功！");
                        $("#addStuForm")[0].reset();
                        $('#showImage').attr('src', '${pageContext.request.contextPath}/images/user.jpg');
                    } else {
                        layer.msg("添加失败！");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg("添加失败！请求超时！服务器繁忙，请稍后重试！");
                }
            });
            return false;
        });

    });

    //异步加载班级
    $.ajax({
        url: "${pageContext.request.contextPath}/stuController/findClsList"
        , dataType: "json"
        , timeout: 3000
        , type: "post"
        , success: function (data) {
            $("select[name='cls.cno'] option:not(:first)").remove();
            $.each(data, function (i, v) {
                $("select[name='cls.cno']").append("<option value='" + v.cno + "'>" + v.cname + "</option>");
            });
            layui.use('form', function () {
                layui.form.render('select');
            });
        }
        , error: function (XMLHttpRequest, textStatus, errorThrown) {
            layui.use('layer', function () {
                layui.layer.msg("班级加载失败！<br/>服务器繁忙，请稍后重试！");
            });
        }
    });
</script>
</body>
</html>
