<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回访信息管理</title>
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
		<li class="active"><a href="${ctx}/baoxiu_huifang/baoxiuHuifang/">回访信息列表</a></li>
		<shiro:hasPermission name="baoxiu_huifang:baoxiuHuifang:edit"><li><a href="${ctx}/baoxiu_huifang/baoxiuHuifang/form?xinxiId=${xinxiObj.id}">回访信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baoxiuHuifang" action="${ctx}/baoxiu_huifang/baoxiuHuifang/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="返回" onclick="javascript:history.go(-1)"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th colspan="3">维修内容：${xinxiObj.mingcheng}</th>
			</tr>
			<tr>
				<th>回访简述</th>
				<th>录入人</th>
				<shiro:hasPermission name="baoxiu_huifang:baoxiuHuifang:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baoxiuHuifang">
			<tr>
				<td><a href="${ctx}/baoxiu_huifang/baoxiuHuifang/form?id=${baoxiuHuifang.id}">
					${baoxiuHuifang.mingcheng}
				</a></td>
				<td>
					${baoxiuHuifang.createBy.name}
				</td>
				<shiro:hasPermission name="baoxiu_huifang:baoxiuHuifang:edit"><td>
    				<a href="${ctx}/baoxiu_huifang/baoxiuHuifang/form?id=${baoxiuHuifang.id}">修改</a>
					<a href="${ctx}/baoxiu_huifang/baoxiuHuifang/delete?id=${baoxiuHuifang.id}" onclick="return confirmx('确认要删除该回访信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>