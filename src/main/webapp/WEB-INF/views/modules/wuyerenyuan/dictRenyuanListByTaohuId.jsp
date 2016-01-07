<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>住户信息管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wuyerenyuan/dictRenyuan/">住户信息列表</a></li>
	</ul>
	<input id="path" type="hidden" value="${dictRenyuan.path }" />
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="220px">位置</th>
				<th>姓名</th>
				<th>性别</th>
				<th>人员类型</th>
				<th>随身电话</th>
				<th>迁入日期</th>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:move"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${userList}" var="dictRenyuan">
			<tr>
				<td>
					${dictRenyuan.path}
				</td>
				<td>
					${dictRenyuan.xingming}
				</td>
				<td>
					${fns:getDictLabel(dictRenyuan.xingbie, 'sex', '')}
				</td>
				<td>
					${fns:getDictLabel(dictRenyuan.renyuanlx, 'd_zhlx', '')}
				</td>
				<td>
					${dictRenyuan.suishendh}
				</td>
				<td>
					<fmt:formatDate value="${dictRenyuan.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:move">
				<td>
					<a href="${ctx}/wuyetaohu/dictTaohu/moveOut?id=${dictRenyuan.id}&pid=${param.pid}">迁出</a>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>