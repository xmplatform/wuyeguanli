<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资料信息管理</title>
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
		<li><a href="${ctx}/wuyetuzhi/dictLoucengtuzhi/">资料信息列表</a></li>
		<li class="active"><a href="${ctx}/wuyetuzhi/dictLoucengtuzhi/form?id=${dictLoucengtuzhi.id}">资料信息<shiro:hasPermission name="wuyetuzhi:dictLoucengtuzhi:edit">${not empty dictLoucengtuzhi.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wuyetuzhi:dictLoucengtuzhi:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dictLoucengtuzhi" action="${ctx}/wuyetuzhi/dictLoucengtuzhi/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型：</label>
			<div class="controls">
				<form:select path="leixing" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('d_lczltz')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图纸：</label>
			<div class="controls">
				<form:hidden id="tuzhi" path="tuzhi" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="tuzhi" type="files" uploadPath="/wuyetuzhi/dictLoucengtuzhi" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wuyetuzhi:dictLoucengtuzhi:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>