<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>套户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#selectAll').click(function(){
				$('input[name="taohuId"]').attr("checked",this.checked);
			});
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		function tianjia(){
			var pids='${pids}';
			//选了单元
			var ids=pids.split(',');
			if(ids.length==4){
				window.location.href="${ctx}/wuyetaohu/dictTaohu/form?pids=${pids}";
			}else
				$('checkbox [name=]').attr("checked",true);
		}
		function delSelect(){
			var idArr=[];
			$('input[name="taohuId"]:checked').each(function(){
				idArr.push($(this).val());
			});
			if(idArr.length>0){
				confirmx('确认要删除这些套户吗？', '${ctx}//wuyetaohu/dictTaohu/delete?id='+idArr.join(','));
			}else
				alert("请选择要删除的数据");
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wuyetaohu/dictTaohu/">套户列表</a></li>
		<shiro:hasPermission name="wuyetaohu:dictTaohu:edit">
			<li><a href="javascript:tianjia()">套户添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictTaohu" action="${ctx}/wuyetaohu/dictTaohu/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input onclick="delSelect()" class="btn btn-primary" type="button" value="删除"/></li>
			<li><label>户型：</label>
				<form:input path="huxing" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>销售状态：</label>
				<form:radiobuttons path="xiaoshouzt" items="${fns:getDictList('d_xszt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>使用状态：</label>
				<form:radiobuttons path="shiyongzt" items="${fns:getDictList('d_syzt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="10px"><input type="checkbox" id="selectAll" /></th>
				<th width="200px">位置</th>
				<th>门牌号</th>
				<th>户型</th>
				<th>销售状态</th>
				<th>使用状态</th>
				<th>户主</th>
				<th>户主电话</th>
				<th>住户查看</th>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:sale"><th>销售</th></shiro:hasPermission>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictTaohu">
			<tr>
				<td>
					<input type="checkbox" value="${dictTaohu.id}" name="taohuId">
				</td>
				<td>
					${dictTaohu.weizhi}
				</td>
				<td><a href="${ctx}/wuyetaohu/dictTaohu/form?id=${dictTaohu.id}">
					${dictTaohu.menpai}
				</a></td>
				<td>
					${dictTaohu.huxing}
				</td>
				<td>
					${fns:getDictLabel(dictTaohu.xiaoshouzt, 'd_xszt', '')}
				</td>
				<td>
					${fns:getDictLabel(dictTaohu.shiyongzt, 'd_syzt', '')}
				</td>
				<td>
					${dictTaohu.huzhu.xingming}
				</td>
				<td>
					${dictTaohu.huzhu.suishendh}
				</td>
				<td>
					<c:if test="${dictTaohu.num>0 }">
						<a href="${ctx}/wuyerenyuan/dictRenyuan/searchByTaohuId?pid=${dictTaohu.id}" target="_blank">${dictTaohu.num } 人</a>
					</c:if>
				</td>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:sale">
					<td>
						<c:if test="${dictTaohu.xiaoshouzt eq 0 }">
		    				<a href="${ctx}/wuyetaohu/dictTaohu/turnToSale?id=${dictTaohu.id}">销售</a>
						</c:if>
					</td>
				</shiro:hasPermission>
				<shiro:hasPermission name="wuyetaohu:dictTaohu:edit">
					<td>
	    				<a href="${ctx}/wuyetaohu/dictTaohu/form?id=${dictTaohu.id}">修改</a>
						<a href="${ctx}/wuyetaohu/dictTaohu/delete?id=${dictTaohu.id}" onclick="return confirmx('确认要删除该套户吗？', this.href)">删除</a>
					</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>