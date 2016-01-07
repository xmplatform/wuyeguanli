<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车位出租</title>
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
		<li><a href="${ctx}/wuyechewei/dictChewei/">车位列表</a></li>
		<li class="active"><a href="${ctx}/wuyechewei/dictChewei/form?id=${dictChewei.id}">
			车位<shiro:hasPermission name="wuyechewei:dictChewei:sale">出租</shiro:hasPermission>
			<shiro:lacksPermission name="wuyechewei:dictChewei:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="200">车位卡</th>
				<th>车位名</th>
				<th>车位位置</th>
				<th>所属区域</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dictChewei.cheweikh}</td>
				<td>${dictChewei.mingcheng }</td>
				<td>${dictChewei.weizhi }</td>
				<td>${fns:getDictLabel(dictChewei.suoshuquyu, 'd_ssqy', '')}</td>
			</tr>
		</tbody>
	</table>
	<form:form id="inputForm" modelAttribute="dictChewei" action="${ctx}/wuyechewei/dictChewei/chuzu" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">起始时间：</label>
			<div class="controls">
				<input name="kaishisj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${dictTaohu.kaishisj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="jieshusj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${dictTaohu.jieshusj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
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
			<label class="control-label">出租价格：</label>
			<div class="controls">
				<form:input path="chuzujg" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wuyechewei:dictChewei:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>