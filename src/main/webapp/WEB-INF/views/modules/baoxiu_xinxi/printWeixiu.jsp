<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报修信息单</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic }/jquery-plugin/print.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic }/jquery-plugin/jquery.PrintArea.js"></script>
</head>
<body>
	<div id="printContent">
		<p id="header">
			<span>客户维修单</span>
		</p>
		<table>
			<tr>
				<td colspan="6" class="kehu">
					单号：${fn:substring(baoxiuXinxi.id,0,12) }
				</td>
			</tr>
			<tr>
				<td colspan="2" class="kehu">位置：${baoxiuXinxi.taohuid }</td>
				<td colspan="3" class="kehu">
					预约时间：<fmt:formatDate value="${baoxiuXinxi.yuyuesj}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td colspan="3" class="kehu">联系电话：${baoxiuXinxi.dianhua }</td>
			</tr>
			<tr>
				<td colspan="6" class="kehu">报修信息</td>
			</tr>
			<tr>
				<td colspan="6" style="text-align:left;">
					${baoxiuXinxi.mingcheng }<br />
					${baoxiuXinxi.remarks }
				</td>
			</tr>
			<tr>
				<td colspan="6" class="kehu">收费明细</td>
			</tr>
			<tr>
				<td width="20%">品名</td>
				<td width="20%">规格</td>
				<td width="10%">单价</td>
				<td width="10%">数量</td>
				<td width="20%">金额</td>
				<td>备注</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" class="yue">维修员：${baoxiuXinxi.weixiuy.name }</td>
				<td colspan="2" class="yue">客户签字：</td>
			</tr>
		</table>
	</div>
	<button onclick="javascript:$('#printContent').printArea();" style="margin:10px 0 0 350px;">打印</button>
</body>
</html>
