<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回访管理</title>
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
		<li class="active"><a href="${ctx}/jianyi_huifang/jianyiHuifang/">回访列表</a></li>
		<shiro:hasPermission name="jianyi_huifang:jianyiHuifang:edit"><li><a href="${ctx}/jianyi_huifang/jianyiHuifang/form">回访添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jianyiHuifang" action="${ctx}/jianyi_huifang/jianyiHuifang/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>信息id：</label>
				<form:input path="xinxiid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>回访简述</th>
				<th>信息id</th>
				<th>录入人</th>
				<shiro:hasPermission name="jianyi_huifang:jianyiHuifang:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jianyiHuifang">
			<tr>
				<td><a href="${ctx}/jianyi_huifang/jianyiHuifang/form?id=${jianyiHuifang.id}">
					${jianyiHuifang.mingcheng}
				</a></td>
				<td>
					${jianyiHuifang.xinxiid}
				</td>
				<td>
					${jianyiHuifang.createBy.id}
				</td>
				<shiro:hasPermission name="jianyi_huifang:jianyiHuifang:edit"><td>
    				<a href="${ctx}/jianyi_huifang/jianyiHuifang/form?id=${jianyiHuifang.id}">修改</a>
					<a href="${ctx}/jianyi_huifang/jianyiHuifang/delete?id=${jianyiHuifang.id}" onclick="return confirmx('确认要删除该回访吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>