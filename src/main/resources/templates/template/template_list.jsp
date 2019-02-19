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
    <title>template数据列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${domain}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${domain}/layuiadmin/style/admin.css" media="all">
</head>
<body>
<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>组件</cite></a>
        <a><cite>数据表格</cite></a>
        <a><cite>开启头部工具栏</cite></a>
    </div>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <%-- 查询条件 --%>
            <div class="layui-card">
                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <div class="layui-card-header">查询条件</div>
                    <div class="layui-card-body layui-row layui-col-space10">
                        <div class="layui-col-md3">
                            <label class="layui-form-label">字段1：</label>
                            <div class="layui-input-block">
                                <input type="text" name="column1" placeholder="字段1的查询条件"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <label class="layui-form-label">字段2：</label>
                            <div class="layui-input-block">
                                <input type="text" name="column2" placeholder="字段2的查询条件"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <label class="layui-form-label">字段3：</label>
                            <div class="layui-input-block">
                                <input type="text" name="column3" placeholder="字段3的查询条件"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <label class="layui-form-label">字段4：</label>
                            <div class="layui-input-block">
                                <input type="text" name="column4" placeholder="字段4的查询条件"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layuiadmin-btn-list" lay-submit lay-filter="form-search">
                                    <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i> 查询
                                </button>
                                <button class="layui-btn layui-btn-primary layuiadmin-btn-list" lay-filter="form-reset">
                                    <i class="layui-icon layui-icon-refresh layuiadmin-button-btn"></i> 重置
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%-- 数据表格 --%>
            <div class="layui-card">
                <div class="layui-card-body">
                    <div style="padding-bottom: 10px;">
                        <button class="layui-btn layuiadmin-btn-list" data-type="save">添加</button>
                        <button class="layui-btn layui-btn-danger layuiadmin-btn-list" data-type="batchdel">批量删除</button>
                    </div>

                    <table class="layui-hide" id="data-table" lay-filter="data-table"></table>

                    <script type="text/html" id="table-toolbar">
                        <a class="layui-btn layui-btn-xs" lay-event="modify">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${domain}/layuiadmin/layui/layui.js"></script>
<script>
    layui.use(['table'], function () {
        var $ = layui.$;
        var table = layui.table;
        var form = layui.form;

        //监听搜索
        form.on('submit(form-search)', function (data) {
            var field = data.field;
            console.info(field);

            //执行重载(查询条件)
            table.reload('data-table', {
                where: field
            });
        });

        var active = {
            batchdel: function () {
                layer.msg('执行批量删除(尚未实现)');
            },
            save: function () {
                layer.open({
                    type: 2,
                    title: '添加template',
                    content: '${domain}/template/go_template_save', //连接
                    maxmin: true,
                    area: ['800px', '550px'],
                    btn: ['确定', '取消'], yes: function (index, layero) {
                        layer.msg('提交成功');

                        //点击确认触发 iframe 内容中的按钮提交
                        var submit = layero.find('iframe').contents().find("#form-save-submit");
                        submit.click();
                    }
                });
            }
        };

        $('.layui-btn.layuiadmin-btn-list').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.render({
            elem: '#data-table',
            url: '${domain}/template',
            toolbar: false,
            defaultToolbar: [],
            title: '用户数据表',
            page: true,
            loading: true,
            limit: 10,
            limits: [10, 30, 50, 100],
            cols: [[
                {type: 'checkbox', fixed: 'left', field: 'id', title: 'id'},
                {field: 'column1', title: '字段1', sort: true},
                {field: 'column2', title: '字段2', sort: false},
                {field: 'column3', title: '字段3', sort: false},
                {field: 'column4', title: '字段4', sort: false},
                {field: 'column5', title: '字段5', sort: false},
                {field: 'beginDt', title: '开始时间', sort: true},
                {field: 'endDt', title: '结束时间', sort: true},
                {field: 'createdDt', title: '创建时间', sort: true},
                {fixed: 'right', title: '操作', toolbar: '#table-toolbar', width: 150}
            ]],
            parseData: function (result) {
                return {
                    'code': '0', //解析接口状态
                    'msg': '加载成功', //解析提示文本
                    'count': result.totalElements, //解析数据长度
                    'data': result.content //解析数据列表
                };
            },
            request: {
                pageName: 'pageNo',
                limitName: 'limit'
            }
        });

        //监听行工具事件
        table.on('tool(table-toolbar)', function (obj) {
            var data = obj.data;
            if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'modify') {
                layer.prompt({
                    formType: 2,
                    value: data.email
                }, function (value, index) {
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });

    function datetimeFormat(v) {
        var date = new Date(v);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = date.getHours();
        h = h < 10 ? ("0" + h) : h;
        var M = date.getMinutes();
        M = M < 10 ? ("0" + M) : M;
        var str = y + "-" + m + "-" + d + " " + h + ":" + M;
        console.info(str);

        return str;
    }
</script>
</body>
</html>