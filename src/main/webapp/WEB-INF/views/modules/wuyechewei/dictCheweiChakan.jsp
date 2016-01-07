<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车位信息查看</title>
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
		<li><a href="${ctx}/wuyechewei/dictChewei/">车位信息表</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dictChewei" action="${ctx}/wuyechewei/dictChewei/chushou" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">车位卡号：</label>
			<div class="controls">
				${dictChewei.cheweikh }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车位名称：</label>
			<div class="controls">
				${dictChewei.mingcheng }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属住户：</label>
			<div class="controls">
				${dictChewei.renyuan.xingming}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				${dictChewei.renyuan.suishendh}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车位状态：</label>
			<div class="controls">
				${fns:getDictLabel(dictChewei.zhuangtai, 'd_cwzt', '')}
			</div>
		</div>
		
		<c:choose>
			<c:when test="${dictChewei.zhuangtai==1 }">
				<div class="control-group">
					<label class="control-label">出售价格：</label>
					<div class="controls">
						${dictChewei.xiaoshoujg}
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">出售日期：</label>
					<div class="controls">
						<fmt:formatDate value="${dictChewei.xiaoshousj }" pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="control-group">
					<label class="control-label">出租价格：</label>
					<div class="controls">
						${dictChewei.chuzujg}
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">出租开始日期：</label>
					<div class="controls">
						<fmt:formatDate value="${dictChewei.kaishisj }" pattern="yyyy-MM-dd"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">出租结束日期：</label>
					<div class="controls">
						<fmt:formatDate value="${dictChewei.jieshusj }" pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="control-group">
			<label class="control-label">车位位置：</label>
			<div class="controls">
				${dictChewei.weizhi }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车位价值：</label>
			<div class="controls">
				${dictChewei.jiazhi }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属区域：</label>
			<div class="controls">
				${fns:getDictLabel(dictChewei.suoshuquyu, 'd_ssqy', '')}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				${dictChewei.remarks }
			</div>
		</div>
	</form:form>
</body>
</html>