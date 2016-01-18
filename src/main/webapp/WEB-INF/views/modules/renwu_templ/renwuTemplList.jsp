<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			var tpl = $("#treeTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
			var data = ${fns:toJson(list)}, ids = [], rootIds = [];
			for (var i=0; i<data.length; i++){
				ids.push(data[i].id);
			}
			ids = ',' + ids.join(',') + ',';
			for (var i=0; i<data.length; i++){
				if (ids.indexOf(','+data[i].parentId+',') == -1){
					if ((','+rootIds.join(',')+',').indexOf(','+data[i].parentId+',') == -1){
						rootIds.push(data[i].parentId);
					}
				}
			}
			for (var i=0; i<rootIds.length; i++){
				addRow("#treeTableList", tpl, data, rootIds[i], true);
			}
			$("#treeTable").treeTable({expandLevel : 5});
		});
		function addRow(list, tpl, data, pid, root){
			for (var i=0; i<data.length; i++){
				var row = data[i];
				if ((${fns:jsGetVal('row.parentId')}) == pid){
					$(list).append(Mustache.render(tpl, {
						dict: {
						blank123:0}, pid: (root?0:pid), row: row
					}));
					addRow(list, tpl, data, row.id);
				}
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/renwu_templ/renwuTempl/">计划列表</a></li>
		<shiro:hasPermission name="renwu_templ:renwuTempl:edit"><li><a href="${ctx}/renwu_templ/renwuTempl/form">计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="renwuTempl" action="${ctx}/renwu_templ/renwuTempl/" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>任务部门：</label>
				<sys:treeselect id="taskdep" name="taskdep.id" value="${renwuTempl.taskdep.id}" labelName="taskdep.name" labelValue="${renwuTempl.taskdep.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>任务周期</th>
				<th>任务部门</th>
				<shiro:hasPermission name="renwu_templ:renwuTempl:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="treeTableList"></tbody>
	</table>
	<script type="text/template" id="treeTableTpl">
		<tr id="{{row.id}}" pId="{{pid}}">
			<td><a href="${ctx}/renwu_templ/renwuTempl/form?id={{row.id}}">
				{{row.mingcheng}}
			</a></td>
			<td>
				{{row.taskcycle}}
			</td>
			<td>
				{{row.taskdep.name}}
			</td>
			<shiro:hasPermission name="renwu_templ:renwuTempl:edit"><td>
   				<a href="${ctx}/renwu_templ/renwuTempl/form?id={{row.id}}">修改</a>
				<a href="${ctx}/renwu_templ/renwuTempl/delete?id={{row.id}}" onclick="return confirmx('确认要删除该计划及所有子计划吗？', this.href)">删除</a>
				<a href="${ctx}/renwu_templ/renwuTempl/form?parent.id={{row.id}}">添加下级计划</a> 
			</td></shiro:hasPermission>
		</tr>
	</script>
</body>
</html>