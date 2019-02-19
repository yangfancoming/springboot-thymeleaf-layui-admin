<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2019/2/8
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../../common/include.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加template数据</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${domain}/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>TEMPLATE</legend>
</fieldset>
<form action="" class="layui-form" id="template-save-form" lay-filter="template-save-form" style="padding: 20px 30px 0 0;">

    <div class="layui-form-item">
        <label class="layui-form-label">字段1</label>
        <div class="layui-input-block">
            <input type="text" name="column1" lay-verify="required" placeholder="字段1" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字段2</label>
        <div class="layui-input-block">
            <input type="text" name="column2" lay-verify="required" placeholder="字段2" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字段3</label>
        <div class="layui-input-block">
            <input type="text" name="column3" lay-verify="required" placeholder="字段3" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字段4</label>
        <div class="layui-input-block">
            <input type="text" name="column4" lay-verify="required" placeholder="字段4" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字段5</label>
        <div class="layui-input-block">
            <input type="text" name="column5" lay-verify="required" placeholder="字段5" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="form-save-submit" id="form-save-submit"
               value="确认添加">
        <input type="button" lay-submit lay-filter="form-edit-submit" id="form-edit-submit"
               value="确认编辑">
    </div>
</form>
<script src="${domain}/layuiadmin/layui/layui.js"></script>
<script src="${domain}/layuiadmin/lib/jquery-3.3.1.min.js"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form;

        //监听提交
        form.on('submit(form-save-submit)', function (data) {
            var field = data.field; //获取提交的字段(将数据提交至服务端)
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引

            console.info(field);

            //提交 Ajax 成功后，关闭当前弹层并重载表格
            //$.ajax({});
            $.ajax({
                url: '${domain}/template/save',
                type: 'post',
                data: JSON.stringify(field),
                dataType: 'json',
                contentType: "application/json",
                success: function (result) {
                    if (result === 1) {
                        layer.msg('提交成功', {icon: 1});
                        parent.layui.table.reload('data-table'); //重载表格
                        parent.layer.close(index); //再执行关闭
                    } else {
                        layer.msg('提交失败', {icon: 5})
                    }
                },
                error: function () {
                    layer.msg('请求出错 可能是网络原因所导致', {icon: 5})
                }
            });
        });
    })
</script>
</body>
</html>