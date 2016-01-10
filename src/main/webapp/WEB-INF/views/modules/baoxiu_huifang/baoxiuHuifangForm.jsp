<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回访信息管理</title>
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
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/baoxiu_huifang/baoxiuHuifang/list">回访信息列表</a></li>
		<li class="active"><a href="${ctx}/baoxiu_huifang/baoxiuHuifang/form?id=${baoxiuHuifang.id}">回访信息<shiro:hasPermission name="baoxiu_huifang:baoxiuHuifang:edit">${not empty baoxiuHuifang.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="baoxiu_huifang:baoxiuHuifang:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="baoxiuHuifang" action="${ctx}/baoxiu_huifang/baoxiuHuifang/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<input type="hidden" name="xinxiId" value=${xinxiId }/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">回访简述：</label>
			<div class="controls">
				<form:textarea path="mingcheng" htmlEscape="false" rows="4" maxlength="60" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="baoxiu_huifang:baoxiuHuifang:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>