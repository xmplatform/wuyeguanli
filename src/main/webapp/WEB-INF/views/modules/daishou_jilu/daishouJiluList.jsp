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
		<li class="active"><a href="${ctx}/daishou_jilu/daishouJilu/">信息列表</a></li>
		<shiro:hasPermission name="daishou_jilu:daishouJilu:edit"><li><a href="${ctx}/daishou_jilu/daishouJilu/form">信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="daishouJilu" action="${ctx}/daishou_jilu/daishouJilu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>收货人姓名：</label>
				<form:input path="shouhuoxm" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>物流公司：</label>
				<form:select path="wuliugs.id" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${wuliuList }" itemLabel="mingcheng" itemValue="id" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>收货人姓名</th>
				<th>收货人电话</th>
				<th>收货人地址</th>
				<th>存放时间</th>
				<th>物流公司</th>
				<th>货柜</th>
				<th>货物条码</th>
				<th>取货二维码</th>
				<shiro:hasPermission name="daishou_jilu:daishouJilu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="daishouJilu">
			<tr>
				<td><a href="${ctx}/daishou_jilu/daishouJilu/form?id=${daishouJilu.id}">
					${daishouJilu.shouhuoxm}
				</a></td>
				<td>
					${daishouJilu.shouhuodh}
				</td>
				<td>
					${daishouJilu.shouhuodz}
				</td>
				<td>
					<fmt:formatDate value="${daishouJilu.cunfangsj}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${daishouJilu.wuliugs.mingcheng}
				</td>
				<td>
					${daishouJilu.huogui.mingcheng}
				</td>
				<td>
					${daishouJilu.huowutm}
				</td>
				<td>
					<a target="_blank" href="${pageContext.request.contextPath}/userfiles/${daishouJilu.id }.jpg">查看</a>
				</td>
				<shiro:hasPermission name="daishou_jilu:daishouJilu:edit"><td>
    				<a href="${ctx}/daishou_jilu/daishouJilu/form?id=${daishouJilu.id}">修改</a>
					<a href="${ctx}/daishou_jilu/daishouJilu/delete?id=${daishouJilu.id}" onclick="return confirmx('确认要删除该信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>