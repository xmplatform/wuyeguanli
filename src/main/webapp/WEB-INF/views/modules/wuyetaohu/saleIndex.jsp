<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>房屋销售</title>
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
		<li class="active"><a href="#">套户销售-户主添加</a></li>
	</ul><br/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="200">位置</th>
				<th>门牌号</th>
				<th>户型</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dictTaohu.weizhi}</td>
				<td>${dictTaohu.menpai }</td>
				<td>${dictTaohu.huxing }</td>
			</tr>
		</tbody>
	</table>
	<form:form id="inputForm" modelAttribute="dictRenyuan"  action="${ctx}/wuyetaohu/dictTaohu/sale" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="pid" />
		<form:hidden path="pids" />
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="xingming" htmlEscape="false" maxlength="12" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别：</label>
			<div class="controls">
				<form:radiobuttons path="xingbie" items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证：</label>
			<div class="controls">
				<form:input path="shengfenz" htmlEscape="false" maxlength="18" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作单位：</label>
			<div class="controls">
				<form:input path="gongzuodw" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">住宅电话：</label>
			<div class="controls">
				<form:input path="zhuzhaidh" htmlEscape="false" maxlength="18" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单位电话：</label>
			<div class="controls">
				<form:input path="danweidh" htmlEscape="false" maxlength="18" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">随身电话：</label>
			<div class="controls">
				<form:input path="suishendh" htmlEscape="false" maxlength="18" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">户口所在地：</label>
			<div class="controls">
				<form:input path="hukouszd" htmlEscape="false" maxlength="60" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">照片：</label>
			<div class="controls">
				<form:hidden id="zhaopian" path="zhaopian" htmlEscape="false" maxlength="120" class="input-xlarge"/>
				<sys:ckfinder input="zhaopian" type="files" uploadPath="/wuyerenyuan/dictRenyuan" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wuyetaohu:dictTaohu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>