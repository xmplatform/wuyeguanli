<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单元信息管理</title>
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
		function tianjia(){
			var pids='${pids}';
			var ids=pids.split(',');
			if(ids.length==3){
				window.location.href="${ctx}/wuyedanyuan/wuyeDanyuan/form?pids=${pids}";
			}else
				alert("请选择楼栋号!");
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wuyedanyuan/wuyeDanyuan/">单元信息列表</a></li>
		<shiro:hasPermission name="loudong:dictLoudong:edit">
			<li><a href="javascript:tianjia()">单元信息添加</a></li>
		</shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="250px">位置</th>
				<th>名称</th>
				<shiro:hasPermission name="wuyedanyuan:wuyeDanyuan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="wuyeDanyuan">
			<tr>
				<td>
					${wuyeDanyuan.path}
				</td>
				<td><a href="${ctx}/wuyedanyuan/wuyeDanyuan/form?id=${wuyeDanyuan.id}">
					${wuyeDanyuan.mingcheng}
				</a></td>
				<shiro:hasPermission name="wuyedanyuan:wuyeDanyuan:edit"><td>
    				<a href="${ctx}/wuyedanyuan/wuyeDanyuan/form?id=${wuyeDanyuan.id}">修改</a>
					<a href="${ctx}/wuyedanyuan/wuyeDanyuan/delete?id=${wuyeDanyuan.id}" onclick="return confirmx('确认要删除该单元信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>