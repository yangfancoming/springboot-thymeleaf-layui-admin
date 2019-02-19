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
    <title>修改template数据</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${domain}/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
<div class="layui-form" id="template-add-form" lay-filter="template-add-form"
     style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">文章标题</label>
        <div class="layui-input-inline">
            <input type="text" name="title" lay-verify="required" placeholder="请输入用户名" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发布人</label>
        <div class="layui-input-inline">
            <input type="text" name="author" lay-verify="required" placeholder="请输入号码" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">文章内容</label>
        <div class="layui-input-inline">
            <textarea name="content" lay-verify="required" style="width: 400px; height: 150px;" autocomplete="off"
                      class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标签</label>
        <div class="layui-input-inline">
            <select name="label" lay-verify="required">
                <option value="">请选择标签</option>
                <option value="美食">美食</option>
                <option value="新闻">新闻</option>
                <option value="八卦">八卦</option>
                <option value="体育">体育</option>
                <option value="音乐">音乐</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发布状态</label>
        <div class="layui-input-inline">
            <input type="checkbox" lay-verify="required" lay-filter="status" name="status" lay-skin="switch"
                   lay-text="已发布|待修改">
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="form-update-submit" id="form-update-submit"
               value="确认添加">
        <input type="button" lay-submit lay-filter="form-edit-submit" id="form-edit-submit"
               value="确认编辑">
    </div>
</div>
<script src="${domain}/layuiadmin/layui/layui.js"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form;

        //监听提交
        form.on('submit(form-add-submit)', function (data) {
            var field = data.field; //获取提交的字段(将数据提交至服务端)
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引

            //提交 Ajax 成功后，关闭当前弹层并重载表格
            //$.ajax({});
            parent.layui.table.reload('data-table'); //重载表格
            parent.layer.close(index); //再执行关闭
        });
    })
</script>
</body>
</html>