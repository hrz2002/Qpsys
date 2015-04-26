<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="./common/css/login-style.css" />
<script src="./common/js/jquery.js" type="text/javascript"></script>
<script src="./common/js/jquery.login.js" type="text/javascript"></script>
</head>
<body>
<%-- style="overflow:hidden;" --%>
<br></br><br></br>
<div style="text-align:center">
<table style="margin:auto">
<!--
<td><img src="./common/images/333home.jpg" alt="Home" /></td> -->
</table>
</div>
<br></br>
<div style="text-align:center">
<table class="table1">
<s:form id="loginForm" method="post">
	<tr style="height: 20px"></tr>
	<tr id="pageLinks" style="visibility: hidden;">
		<td align="right">
			<img src="./common/images/icon_error_lrg.gif" align="middle"></img>
		</td>
		<td colspan="3">
			<s:label value="登録失敗、你好请您重新"></s:label>
		</td>
	</tr>
	<tr>
		<td>
			<s:label cssClass="label" for="userid" value="UserId"/>
		</td>
		<td colspan="3">
			<s:textfield id="userid" name="userid"/>
		</td>
	</tr>
	<tr>
		<td>
			<s:label cssClass="label"  for="passwd" value="passwd"/>
		</td>
		<td colspan="3">
			<s:password id="passwd" name="passwd"/>
		</td>
	</tr>
	<tr>
		<td>
			<s:label cssClass="label" for="pic" value="Input me"/>
		</td>
		<td>
			<s:textfield id="inputimg" name="inputimg" cssStyle="width:130px;" maxlength="10" size="10"/>
		</td>
		<td>
			<img src="randNum" id="numpic" style="border:solid maroon;margin-top: 2px" alt="看不清点击刷新" class="ReloadCode"/>
		</td>
		<td></td>
	</tr>
	<tr style="height: 8px"></tr>
	<tr>
		<td></td>
		<td style="text-align: right;">
			<s:submit cssClass="button" name="submit" value="Log in"/>
		</td>
		<td>
			<s:reset cssClass="button" name="reset" value="Cancel"/>
		</td>
		<td></td>
	</tr>
	<tr style="height: 12px"></tr>
</s:form>
</table>
</div>
</body>
</html>