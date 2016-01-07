<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>排班管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				rules:{
					riStr: {
						required: true
					}
				},
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
			//回填日期
			if($('#zhibansj').val().length==7){
				var ristr='${baoxiuPaiban.riStr}';
				var riStrArr=ristr.split(',');
				myPick();
				$.each(riStrArr,function(i,o){
					$("#id_"+o).attr("checked",true);
				});
			}
		});
		function toggleCheckbox(obj){
			$('[name=riStr]:checkbox').attr('checked',$(obj).attr('checked')=='checked'?true:false);
		}
		function myPick(){
			var arr=$('#zhibansj').val().split('-');
			var strArr=['<input type="checkbox" onclick="toggleCheckbox(this)"/> 全选'];
			for(var i=1;i<=getDaysInMonth(arr[0],arr[1]);i++){
				strArr.push('<input type="checkbox" name="riStr" value='+i+' id="id_'+i+'"/> '+i);
			}
			$('#riDiv').empty().append(strArr.join(''));
		}
		//某年某月有多少天
		function getDaysInMonth(y,m){
			m=parseInt(m,10)+1;
			var t=new Date(y+"/"+m+"/0");
			return t.getDate();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/baoxiu_paiban/baoxiuPaiban/">排班列表</a></li>
		<li class="active"><a href="${ctx}/baoxiu_paiban/baoxiuPaiban/form?id=${baoxiuPaiban.id}">排班<shiro:hasPermission name="baoxiu_paiban:baoxiuPaiban:edit">${not empty baoxiuPaiban.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="baoxiu_paiban:baoxiuPaiban:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="baoxiuPaiban" action="${ctx}/baoxiu_paiban/baoxiuPaiban/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">维修人员：</label>
			<div class="controls">
				<form:select path="renyuanid.id" items="${weixiuList }" itemLabel="name" itemValue="id" class="input-xlarge "></form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">值班日期：</label>
			<div class="controls">
				<input id="zhibansj" name="zhibansj" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate required"
					value="${baoxiuPaiban.zhibansj}"
					onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:false,isShowToday:false,onpicked:myPick});"/>
				<div id='riDiv'></div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="baoxiu_paiban:baoxiuPaiban:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>