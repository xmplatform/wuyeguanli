<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报修信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
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
			if($('#yuyuesj').val().length>0)
				myPick();
		});
		//查找这个日期下的空闲维修员
		function myPick(){
			var str=$('#yuyuesj').val().substring(0,10);
			$.ajax({
				type:"post",
				url:"${ctx}/baoxiu_xinxi/baoxiuXinxi/loadWeixiu",
				data:{yuyuesj:str},
				success:function(objs){
					var arr=[];
					$.each(objs,function(i,o){
						arr.push('<option value="'+o.id+'">'+o.name+'</option>');
					});
					$('#weixiuy\\.id').empty().append(arr.join(''));
				}
			});
		}
		//根据电话号查找所在套户
		function findTaohu(){
			var dianhua=$.trim($('#dianhua').val());
			if(dianhua.length>0)
				$.ajax({
					type:"post",
					url:"${ctx}/wuyetaohu/dictTaohu/findTaohuByShouji",
					data:{dianhua:dianhua},
					success:function(obj){
						if(obj.length>0)
							$('#taohuid').val(obj[0].weizhi);
					}
				});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/">报修信息列表</a></li>
		<li class="active"><a href="${ctx}/baoxiu_xinxi/baoxiuXinxi/form?id=${baoxiuXinxi.id}">报修信息<shiro:hasPermission name="baoxiu_xinxi:baoxiuXinxi:edit">${not empty baoxiuXinxi.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="baoxiu_xinxi:baoxiuXinxi:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="baoxiuXinxi" action="${ctx}/baoxiu_xinxi/baoxiuXinxi/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">报修电话：</label>
			<div class="controls">
				<form:input path="dianhua" onblur="findTaohu()" htmlEscape="false" maxlength="15" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">维修区域：</label>
			<div class="controls">
				<form:select path="weixiuqy" items="${fns:getDictList('d_weixiuqy')}" itemLabel="label" itemValue="value"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">位置：</label>
			<div class="controls">
				<form:input path="taohuid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预约时间：</label>
			<div class="controls">
				<input id="yuyuesj" name="yuyuesj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${baoxiuXinxi.yuyuesj}" pattern="yyyy-MM-dd HH:mm"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false,readOnly:true,minDate:'%y-%M-\#{%d}',onpicked:myPick});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">维修员：</label>
			<div class="controls">
				<form:select path="weixiuy.id" class="input-xlarge "></form:select>
			</div>
		</div>
		<script type="text/javascript">
			WdatePicker({eCont:'test'});
		</script>
		<div class="control-group">
			<label class="control-label">描述：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="baoxiu_xinxi:baoxiuXinxi:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>