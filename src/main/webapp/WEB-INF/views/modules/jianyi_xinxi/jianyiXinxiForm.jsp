<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>建议管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			//请求处理人和处理结果，二者取其一
			$('#chulirenName').bind('change',function(){
				if($(this).val().length==0)
					$('#jieguo').text('').attr('disabled',false);
				else
					$('#jieguo').text('').attr('disabled',true);
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/jianyi_xinxi/jianyiXinxi/">建议列表</a></li>
		<li class="active"><a href="${ctx}/jianyi_xinxi/jianyiXinxi/form?id=${jianyiXinxi.id}">建议<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit">${not empty jianyiXinxi.id?'处理':'添加'}</shiro:hasPermission><shiro:lacksPermission name="jianyi_xinxi:jianyiXinxi:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="jianyiXinxi" action="${ctx}/jianyi_xinxi/jianyiXinxi/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">建议内容：</label>
			<div class="controls">
				${jianyiXinxi.remarks}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议分类：</label>
			<div class="controls">
				${fns:getDictLabel(jianyiXinxi.fenlei, 'd_jyfl', '')}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议状态：</label>
			<div class="controls">
				<c:if test="${jianyiXinxi.zhuangtai==0}">未处理</c:if>
				<c:if test="${jianyiXinxi.zhuangtai==1}">处理中</c:if>
				<c:if test="${jianyiXinxi.zhuangtai==2}">已处理</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">请求处理人：</label>
			<div class="controls">
				<sys:treeselect  id="chuliren" name="chuliren.id" value="${jianyiXinxi.chuliren.id}" labelName="chuliren.name" labelValue="${jianyiXinxi.chuliren.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否发布：</label>
			<div class="controls">
				<form:radiobuttons path="fabu" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处理结果：</label>
			<div class="controls">
				<form:textarea path="jieguo" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>