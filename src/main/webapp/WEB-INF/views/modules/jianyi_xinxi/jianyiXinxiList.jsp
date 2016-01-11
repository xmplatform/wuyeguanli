<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>建议管理</title>
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
		<li class="active"><a href="${ctx}/jianyi_xinxi/jianyiXinxi/">建议列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="jianyiXinxi" action="${ctx}/jianyi_xinxi/jianyiXinxi/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>创建者：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>建议</th>
				<th>建议人</th>
				<th>建议时间</th>
				<th>请求处理人</th>
				<th>建议状态</th>
				<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jianyiXinxi">
			<tr>
				<td>
					<a href="${ctx}/jianyi_xinxi/jianyiXinxi/form?id=${jianyiXinxi.id}">${jianyiXinxi.remarks}</a>
				</td>
				<td>
					${jianyiXinxi.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${jianyiXinxi.createDate}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					${jianyiXinxi.chuliren.name}
				</td>
				<td>
					<c:if test="${jianyiXinxi.zhuangtai==0}">未处理</c:if>
					<c:if test="${jianyiXinxi.zhuangtai==1}">处理中</c:if>
					<c:if test="${jianyiXinxi.zhuangtai==2}">已处理</c:if>
				</td>
				<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit"><td>
    				<a href="${ctx}/jianyi_xinxi/jianyiXinxi/form?id=${jianyiXinxi.id}">修改</a>
					<a href="${ctx}/jianyi_xinxi/jianyiXinxi/delete?id=${jianyiXinxi.id}" onclick="return confirmx('确认要删除该建议吗？', this.href)">删除</a>
					<a href="${ctx}/jianyi_huifang/jianyiHuifang?xinxiid=${jianyiXinxi.id}">客户回访</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>