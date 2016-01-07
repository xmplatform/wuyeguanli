<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>信息管理</title>
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
		<li class="active"><a href="${ctx}/wuyejiben/wuyeJiben/">信息列表</a></li>
		<shiro:hasPermission name="wuyejiben:wuyeJiben:edit"><li><a href="${ctx}/wuyejiben/wuyeJiben/form">信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wuyeJiben" action="${ctx}/wuyejiben/wuyeJiben/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>地址：</label>
				<form:input path="dizhi" htmlEscape="false" maxlength="120" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="dianhua" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>负责人：</label>
				<form:input path="fuzeren" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>人员数</th>
				<th>地址</th>
				<th>电话</th>
				<th>负责人</th>
				<shiro:hasPermission name="wuyejiben:wuyeJiben:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="wuyeJiben">
			<tr>
				<td><a href="${ctx}/wuyejiben/wuyeJiben/form?id=${wuyeJiben.id}">
					${wuyeJiben.mingcheng}
				</a></td>
				<td>
					${wuyeJiben.renshu}
				</td>
				<td>
					${wuyeJiben.dizhi}
				</td>
				<td>
					${wuyeJiben.dianhua}
				</td>
				<td>
					${wuyeJiben.fuzeren}
				</td>
				<shiro:hasPermission name="wuyejiben:wuyeJiben:edit"><td>
    				<a href="${ctx}/wuyejiben/wuyeJiben/form?id=${wuyeJiben.id}">修改</a>
					<a href="${ctx}/wuyejiben/wuyeJiben/delete?id=${wuyeJiben.id}" onclick="return confirmx('确认要删除该信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>