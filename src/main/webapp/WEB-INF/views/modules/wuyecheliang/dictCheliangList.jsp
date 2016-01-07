<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆信息管理</title>
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
		<li class="active"><a href="${ctx}/wuyecheliang/dictCheliang/">车辆信息列表</a></li>
		<shiro:hasPermission name="wuyecheliang:dictCheliang:edit"><li><a href="${ctx}/wuyecheliang/dictCheliang/form">车辆信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictCheliang" action="${ctx}/wuyecheliang/dictCheliang/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车牌号：</label>
				<form:input path="chepai" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>车主姓名：</label>
				<form:input path="renyuan.xingming" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="200px">套户</th>
				<th>车牌号</th>
				<th>车主</th>
				<th>车主电话</th>
				<th>车位</th>
				<th>车卡号</th>
				<th>出入证号</th>
				<th>车辆品牌</th>
				<th>车辆颜色</th>
				<shiro:hasPermission name="wuyecheliang:dictCheliang:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictCheliang">
			<tr>
				<td>
					${dictCheliang.renyuan.path }
				</td>
				<td><a href="${ctx}/wuyecheliang/dictCheliang/form?id=${dictCheliang.id}">
					${dictCheliang.chepai}
				</a></td>
				<td>
					${dictCheliang.renyuan.xingming}
				</td>
				<td>
					${dictCheliang.renyuan.suishendh}
				</td>
				<td>
					${dictCheliang.chewei.mingcheng}
				</td>
				<td>
					${dictCheliang.chekah}
				</td>
				<td>
					${dictCheliang.churuzh}
				</td>
				<td>
					${dictCheliang.pinpai}
				</td>
				<td>
					${dictCheliang.yanse}
				</td>
				<shiro:hasPermission name="wuyecheliang:dictCheliang:edit"><td>
    				<a href="${ctx}/wuyecheliang/dictCheliang/form?id=${dictCheliang.id}">修改</a>
					<a href="${ctx}/wuyecheliang/dictCheliang/delete?id=${dictCheliang.id}" onclick="return confirmx('确认要删除该车辆信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>