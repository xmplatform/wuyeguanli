<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>排班管理</title>
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
		<li class="active"><a href="${ctx}/baoxiu_paiban/baoxiuPaiban/">排班列表</a></li>
		<shiro:hasPermission name="baoxiu_paiban:baoxiuPaiban:edit"><li><a href="${ctx}/baoxiu_paiban/baoxiuPaiban/form">排班添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baoxiuPaiban" action="${ctx}/baoxiu_paiban/baoxiuPaiban/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>维修员：</label>
				<form:input path="renyuanid.name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>值班日：</label>
				<input name="zhibansj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${baoxiuPaiban.zhibansj}" pattern="yyyy-MM"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM'});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>维修员</th>
				<th>值班年月</th>
				<th>日期</th>
				<th>备注</th>
				<shiro:hasPermission name="baoxiu_paiban:baoxiuPaiban:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baoxiuPaiban">
			<tr>
				<td><a href="${ctx}/baoxiu_paiban/baoxiuPaiban/form?id=${baoxiuPaiban.id}">
					${baoxiuPaiban.renyuanid.name}
				</a></td>
				<td>
					${baoxiuPaiban.zhibansj}
				</td>
				<td>
					${baoxiuPaiban.riStr}
				</td>
				<td>${baoxiuPaiban.remarks}</td>
				<shiro:hasPermission name="baoxiu_paiban:baoxiuPaiban:edit"><td>
    				<a href="${ctx}/baoxiu_paiban/baoxiuPaiban/form?id=${baoxiuPaiban.id}">修改</a>
					<a href="${ctx}/baoxiu_paiban/baoxiuPaiban/delete?id=${baoxiuPaiban.id}" onclick="return confirmx('确认要删除该排班吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>