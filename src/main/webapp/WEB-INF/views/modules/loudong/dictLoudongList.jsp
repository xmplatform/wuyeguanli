<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>楼栋信息管理</title>
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
			if(ids.length==2){
				window.location.href="${ctx}/loudong/dictLoudong/form?pids=${pids}";
			}else
				alert("请选择小区!");
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/loudong/dictLoudong/">楼栋信息列表</a></li>
		<shiro:hasPermission name="loudong:dictLoudong:edit">
			<li><a href="javascript:tianjia()">楼栋信息添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictLoudong" action="${ctx}/loudong/dictLoudong/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>属地居委会：</label>
				<form:select path="juweihui" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('d_jwh')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>属地派出所：</label>
				<form:select path="paichusuo" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('d_pcs')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th width="200px">位置</th>
				<th>楼栋名称</th>
				<th>属地居委会</th>
				<th>属地派出所</th>
				<shiro:hasPermission name="loudong:dictLoudong:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictLoudong">
			<tr>
				<td>
					${dictLoudong.path}
				</td>
				<td><a href="${ctx}/loudong/dictLoudong/form?id=${dictLoudong.id}">
					${dictLoudong.mingcheng}
				</a></td>
				<td>
					${fns:getDictLabel(dictLoudong.juweihui, 'd_jwh', '')}
				</td>
				<td>
					${fns:getDictLabel(dictLoudong.juweihui, 'd_pcs', '')}
				</td>
				<shiro:hasPermission name="loudong:dictLoudong:edit"><td>
    				<a href="${ctx}/loudong/dictLoudong/form?id=${dictLoudong.id}">修改</a>
					<a href="${ctx}/loudong/dictLoudong/delete?id=${dictLoudong.id}" onclick="return confirmx('确认要删除该楼栋信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>