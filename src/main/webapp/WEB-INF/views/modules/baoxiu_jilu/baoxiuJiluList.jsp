<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>维修记录管理</title>
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
		<li class="active"><a href="${ctx}/baoxiu_jilu/baoxiuJilu/">维修记录列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="baoxiuJilu" action="" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="返回" onclick="javascript:history.go(-1)"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th colspan="3">报修内容：${xinxiObj.mingcheng}</th>
			</tr>
			<tr>
				<th>维修情况</th>
				<th>创建者</th>
				<shiro:hasPermission name="baoxiu_jilu:baoxiuJilu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baoxiuJilu">
			<tr>
				<td>
					${baoxiuJilu.mingcheng}
				</td>
				<td>
					${baoxiuJilu.createBy.id}
				</td>
				<shiro:hasPermission name="baoxiu_jilu:baoxiuJilu:edit"><td>
    				<a href="${ctx}/baoxiu_jilu/baoxiuJilu/form?id=${baoxiuJilu.id}">修改</a>
					<a href="${ctx}/baoxiu_jilu/baoxiuJilu/delete?id=${baoxiuJilu.id}" onclick="return confirmx('确认要删除该维修记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>