<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报修信息管理</title>
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
		<li class="active"><a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/">报修信息列表</a></li>
		<shiro:hasPermission name="baoxiu_xinxi:baoxiuXinxi:edit"><li><a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/form">报修信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baoxiuXinxi" action="${ctx}/baoxiu_xinxi/baoxiuXinxi/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:input path="zhuangtai" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>报修电话：</label>
				<form:input path="dianhua" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>位置</th>
				<th>报修电话</th>
				<th>预约时间</th>
				<th>接报时间</th>
				<th>维修员</th>
				<th>状态</th>
				<shiro:hasPermission name="baoxiu_xinxi:baoxiuXinxi:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baoxiuXinxi">
			<tr>
				<td>
					<a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/form?id=${baoxiuXinxi.id}">${baoxiuXinxi.mingcheng}</a>
				</td>
				<td>
					${baoxiuXinxi.taohuid}
				</td>
				<td>
					${baoxiuXinxi.dianhua}
				</td>
				<td>
					<fmt:formatDate value="${baoxiuXinxi.yuyuesj}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<fmt:formatDate value="${baoxiuXinxi.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${baoxiuXinxi.weixiuy.name}
				</td>
				<td>
					<c:if test="${baoxiuXinxi.zhuangtai==0 }">已接件</c:if>
					<c:if test="${baoxiuXinxi.zhuangtai==1 }">维修中</c:if>
				</td>
				<shiro:hasPermission name="baoxiu_xinxi:baoxiuXinxi:edit"><td>
    				<a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/form?id=${baoxiuXinxi.id}">修改</a>
					<a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/delete?id=${baoxiuXinxi.id}" onclick="return confirmx('确认要删除该报修信息吗？', this.href)">删除</a>
					<a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/printWeixiu?id=${baoxiuXinxi.id}" target="_blank">打印</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>