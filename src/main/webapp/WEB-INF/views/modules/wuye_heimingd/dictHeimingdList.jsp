<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>黑名单信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wuye_heimingd/dictHeimingd/">黑名单信息列表</a></li>
		<shiro:hasPermission name="wuye_heimingd:dictHeimingd:edit"><li><a href="${ctx}/wuye_heimingd/dictHeimingd/form">黑名单信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictHeimingd" action="${ctx}/wuye_heimingd/dictHeimingd/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="renyuan.xingming" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="200px">路径</th>
				<th>姓名</th>
				<th>原因</th>
				<th>创建时间</th>
				<th>变动时间</th>
				<shiro:hasPermission name="wuye_heimingd:dictHeimingd:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictHeimingd">
			<tr>
				<td>
					${dictHeimingd.renyuan.path}
				</td>
				<td><a href="${ctx}/wuye_heimingd/dictHeimingd/form?id=${dictHeimingd.id}">
					${dictHeimingd.renyuan.xingming}
				</a>
				</td>
				<td>
					${dictHeimingd.remarks}
				</td>
				<td>
					<fmt:formatDate value="${dictHeimingd.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${dictHeimingd.updateDate}" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="wuye_heimingd:dictHeimingd:edit"><td>
    				<a href="${ctx}/wuye_heimingd/dictHeimingd/form?id=${dictHeimingd.id}">修改</a>
					<a href="${ctx}/wuye_heimingd/dictHeimingd/delete?id=${dictHeimingd.id}" onclick="return confirmx('确认要删除该黑名单信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>