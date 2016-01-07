<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>楼栋信息管理</title>
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
		<li><a href="${ctx}/loudong/dictLoudong/">楼栋信息列表</a></li>
		<li class="active"><a href="${ctx}/loudong/dictLoudong/form?id=${dictLoudong.id}">楼栋信息<shiro:hasPermission name="loudong:dictLoudong:edit">${not empty dictLoudong.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="loudong:dictLoudong:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dictLoudong" action="${ctx}/loudong/dictLoudong/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<form:hidden path="pids"  />
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="mingcheng" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产生数量：</label>
			<div class="controls">
				<form:input path="chanshengsl" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">朝向：</label>
			<div class="controls">
				<form:input path="chaoxiang" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">层高：</label>
			<div class="controls">
				<form:input path="cenggao" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">楼栋结构：</label>
			<div class="controls">
				<form:select path="jiegou" class="input-xlarge ">
					<form:options items="${fns:getDictList('d_ld_jg')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">楼栋类型：</label>
			<div class="controls">
				<form:select path="leixing" class="input-xlarge ">
					<form:options items="${fns:getDictList('d_ld_lx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">属地居委会：</label>
			<div class="controls">
				<form:select path="juweihui" class="input-xlarge ">
					<form:options items="${fns:getDictList('d_jwh')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">属地派出所：</label>
			<div class="controls">
				<form:select path="paichusuo" class="input-xlarge ">
					<form:options items="${fns:getDictList('d_pcs')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="tupian" path="tupian" htmlEscape="false" maxlength="120" class="input-xlarge"/>
				<sys:ckfinder input="tupian" type="files" uploadPath="/loudong/dictLoudong" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="loudong:dictLoudong:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>