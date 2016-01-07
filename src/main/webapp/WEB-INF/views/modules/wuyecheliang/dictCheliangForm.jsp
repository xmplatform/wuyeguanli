<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆信息管理</title>
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
		<li><a href="${ctx}/wuyecheliang/dictCheliang/">车辆信息列表</a></li>
		<li class="active"><a href="${ctx}/wuyecheliang/dictCheliang/form?id=${dictCheliang.id}">车辆信息<shiro:hasPermission name="wuyecheliang:dictCheliang:edit">${not empty dictCheliang.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wuyecheliang:dictCheliang:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dictCheliang" action="${ctx}/wuyecheliang/dictCheliang/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">车牌号：</label>
			<div class="controls">
				<form:input path="chepai" htmlEscape="false" maxlength="12" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">住户选择：</label>
			<div class="controls">
				<form:select path="renyuan.id" items="${renyuanList }" itemValue="id" itemLabel="xingming" class="input-xlarge"></form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车卡号：</label>
			<div class="controls">
				<form:input path="chekah" htmlEscape="false" maxlength="12" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车位：</label>
			<div class="controls">
				<form:select path="chewei.id" class="input-xlarge" >
					<form:option value="" label=""/>
					<form:options items="${cheweiList }" itemLabel="mingcheng" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆类型：</label>
			<div class="controls">
				<form:input path="leixing" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆品牌：</label>
			<div class="controls">
				<form:input path="pinpai" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆颜色：</label>
			<div class="controls">
				<form:input path="yanse" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出入证号：</label>
			<div class="controls">
				<form:input path="churuzh" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开始时间：</label>
			<div class="controls">
				<input name="kaishisj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${dictCheliang.kaishisj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="jieshusj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${dictCheliang.jieshusj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wuyecheliang:dictCheliang:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>