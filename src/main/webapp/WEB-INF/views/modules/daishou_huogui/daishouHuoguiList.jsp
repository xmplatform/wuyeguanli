<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>货柜信息管理</title>
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
		<li class="active"><a href="${ctx}/daishou_huogui/daishouHuogui/">货柜信息列表</a></li>
		<shiro:hasPermission name="daishou_huogui:daishouHuogui:edit"><li><a href="${ctx}/daishou_huogui/daishouHuogui/form">货柜信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="daishouHuogui" action="${ctx}/daishou_huogui/daishouHuogui/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>货柜名称：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>货柜号码</th>
				<th>货柜名称</th>
				<th>货柜位置</th>
				<th>货柜说明</th>
				<th>货柜状态</th>
				<shiro:hasPermission name="daishou_huogui:daishouHuogui:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="daishouHuogui">
			<tr>
				<td><a href="${ctx}/daishou_huogui/daishouHuogui/form?id=${daishouHuogui.id}">
					${daishouHuogui.haoma}
				</a></td>
				<td>
					${daishouHuogui.mingcheng}
				</td>
				<td>
					${daishouHuogui.weizhi}
				</td>
				<td>
					${daishouHuogui.remarks}
				</td>
				<td>
					${fns:getDictLabel(daishouHuogui.zhuangtai, 'dict_huoguizt', '')}
				</td>
				<shiro:hasPermission name="daishou_huogui:daishouHuogui:edit"><td>
    				<a href="${ctx}/daishou_huogui/daishouHuogui/form?id=${daishouHuogui.id}">修改</a>
					<a href="${ctx}/daishou_huogui/daishouHuogui/delete?id=${daishouHuogui.id}" onclick="return confirmx('确认要删除该货柜信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>