<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<html>
<head>
    <title>我的商城 | 内容管理</title>
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.css">
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%--导航--%>
    <jsp:include page="../includes/nav.jsp"/>
    <%--菜单栏--%>
    <jsp:include page="../includes/menu.jsp"/>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <%--信息提示框--%>
                    <c:if test="${baseResult !=null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>


                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-default" ><i class="fa fa-trash-o"></i>删除</button>


                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>排序</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tbContentCategories}" var="contentCategory">
                                        <tr id="${contentCategory.id}" pId="${contentCategory.parent.id}">
                                            <td>${contentCategory.id}</td>
                                            <td>${contentCategory.name}</td>
                                            <td>${contentCategory.sortOrder}</td>
                                            <td>
                                                <a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                                <button type="button" class="btn btn-sm btn-danger" ><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 添加下级菜单</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
        </section>
    </div>
    <%--版权--%>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>

<script src="/static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>

<!-- 自定义模态框 -->
<sys:modal />

<script>
    $(function () {
        $("#treeTable").treeTable({
            expandLevel: 2,
            column: 1
        });
    });
</script>
</body>
</html>
