<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车位管理</title>
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
		<li class="active"><a href="${ctx}/wuyechewei/dictChewei/">车位列表</a></li>
		<shiro:hasPermission name="wuyechewei:dictChewei:edit"><li><a href="${ctx}/wuyechewei/dictChewei/form">车位添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictChewei" action="${ctx}/wuyechewei/dictChewei/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车位卡号：</label>
				<form:input path="cheweikh" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>车位名称：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>所属区域：</label>
				<form:select path="suoshuquyu" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('d_ssqy')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>车位状态：</label>
				<form:radiobuttons path="zhuangtai" items="${fns:getDictList('d_cwzt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车位卡号</th>
				<th>车位名称</th>
				<th>所属区域</th>
				<th>位置</th>
				<th>车位状态</th>
				<th>所属业主</th>
				<th>电话</th>
				<th>租售价格</th>
				<shiro:hasPermission name="wuyechewei:dictChewei:sale"><th>车位租售</th></shiro:hasPermission>
				<shiro:hasPermission name="wuyechewei:dictChewei:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictChewei">
			<tr>
				<td><a href="${ctx}/wuyechewei/dictChewei/form?id=${dictChewei.id}">
					${dictChewei.cheweikh}
				</a></td>
				<td>${dictChewei.mingcheng}</td>
				<td>${fns:getDictLabel(dictChewei.suoshuquyu, 'd_ssqy', '')}</td>
				<td>${dictChewei.weizhi}</td>
				<td>
					${fns:getDictLabel(dictChewei.zhuangtai, 'd_cwzt', '')}
				</td>
				<td>${dictChewei.renyuan.xingming}</td>
				<td>${dictChewei.renyuan.suishendh}</td>
				<td>
					<c:choose>
						<c:when test="${dictChewei.zhuangtai==1 }">
							${dictChewei.xiaoshoujg }
						</c:when>
						<c:otherwise>
							${dictChewei.chuzujg }
						</c:otherwise>
					</c:choose>
				</td>
				<shiro:hasPermission name="wuyechewei:dictChewei:edit"><td>
					<c:choose>
						<c:when test="${dictChewei.zhuangtai==0 }">
							<a href="${ctx}/wuyechewei/dictChewei/turn2Chuzu?id=${dictChewei.id}">出租</a>
							<a href="${ctx}/wuyechewei/dictChewei/turn2Chushou?id=${dictChewei.id}">出售</a>
						</c:when>
						<c:otherwise>
							<a href="${ctx}/wuyechewei/dictChewei/turn2Chakan?id=${dictChewei.id}" target="_blank">查看</a>
						</c:otherwise>
					</c:choose>
				</td></shiro:hasPermission>
				<shiro:hasPermission name="wuyechewei:dictChewei:edit"><td>
    				<a href="${ctx}/wuyechewei/dictChewei/form?id=${dictChewei.id}">修改</a>
					<a href="${ctx}/wuyechewei/dictChewei/delete?id=${dictChewei.id}" onclick="return confirmx('确认要删除该车位吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>