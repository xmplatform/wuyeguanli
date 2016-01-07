<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>套户管理</title>
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
		<li><a href="${ctx}/wuyetaohu/dictTaohu/">套户列表</a></li>
		<li class="active"><a href="${ctx}/wuyetaohu/dictTaohu/form?id=${dictTaohu.id}">套户<shiro:hasPermission name="wuyetaohu:dictTaohu:edit">${not empty dictTaohu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wuyetaohu:dictTaohu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dictTaohu" action="${ctx}/wuyetaohu/dictTaohu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		
		<div class="control-group">
			<div class="controls">
				<!-- 公司、小区、楼栋、单元的4个id -->
				<form:hidden path="pids" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">门牌号：</label>
			<div class="controls">
				<form:input path="menpai" htmlEscape="false" maxlength="20" class="input-xlarge integer required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">步长：</label>
			<div class="controls">
				<form:input path="buchang" htmlEscape="false" maxlength="20" class="input-xlarge integer"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产生数量：</label>
			<div class="controls">
				<form:input path="chanshengsl" htmlEscape="false" maxlength="20" class="input-xlarge integer"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">房产证号：</label>
			<div class="controls">
				<form:input path="chanquanzheng" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">户型：</label>
			<div class="controls">
				<form:input path="huxing" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交房时间：</label>
			<div class="controls">
				<input name="jiaofangsj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${dictTaohu.jiaofangsj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">销售状态：</label>
			<div class="controls">
				<form:radiobuttons path="xiaoshouzt" items="${fns:getDictList('d_xszt')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">使用状态：</label>
			<div class="controls">
				<form:radiobuttons path="shiyongzt" items="${fns:getDictList('d_syzt')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">使用面积：</label>
			<div class="controls">
				<form:input path="shiyongpm" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建筑面积：</label>
			<div class="controls">
				<form:input path="jianzhupm" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公摊面积：</label>
			<div class="controls">
				<form:input path="gongtanpm" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计费面积：</label>
			<div class="controls">
				<form:input path="jifeipm" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">房间类型：</label>
			<div class="controls">
				<form:select path="fangjianlx" class="input-xlarge ">
					<form:options items="${fns:getDictList('d_fjlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用途：</label>
			<div class="controls">
				<form:input path="yongtu" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">装修情况：</label>
			<div class="controls">
				<form:radiobuttons path="zhuangxiuqk" items="${fns:getDictList('d_zxqk')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总层高：</label>
			<div class="controls">
				<form:input path="zongcg" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="tupian" path="tupian" htmlEscape="false" maxlength="120" class="input-xlarge"/>
				<sys:ckfinder input="tupian" type="files" uploadPath="/wuyetaohu/dictTaohu" selectMultiple="true"/>
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