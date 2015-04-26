<title>Untitled Document</title>
<common:styleSheet/>
<html>
<head>
<sx:head cache="true" extraLocales="zh-cn"/>
</head>
<body>
<script type="text/javascript">
	function FormReset() {
		myForm0.submit();
	}
	function FormSubmit() {
		myForm.submit();
	}
</script>
<common:header menu_id="add" substitute_title="　MM ＞客户主数据>追加"/>
 <s:fielderror />
<s:form action="back" name="myForm0">
</s:form>
<s:form action="save" name="myForm" method="post">
<div align="center">
<common:outlineTable width="90%">
<table class="listTable" width="90%">
  <col width="110" />
  <col width="142" />
  <col width="66" />
  <col width="82" />
  <col width="83" span="2" />
  <col width="25" span="2" />
  <col/>
  <tr height="40">
    <td scope="col" height="40" colspan="9" >
		详细内容
    </td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" nowrap="nowrap">代表</td>
    <td colspan="3" align="left"><s:textfield size="30" name="customer.name"/></td>
    <td colspan="2" align="center" class="green">邮件地址</td>
    <td colspan="3"><s:textfield size="30" name="customer.mail"/></td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" width="120">电话</td>
    <td colspan="3" align="left"><s:textfield size="30" name="customer.tel" /></td>
    <td colspan="2" align="center" class="green">公司地址</td>
    <td colspan="3"><s:textfield size="30"  name="customer.address"/></td>
  </tr>
  <tr height="24">
    <td align="center" class="green" height="50">备注</td>
    <td colspan="8"><s:textarea rows="3" cols="60" name="customer.other" /></td>
  </tr>
  <s:hidden name="indexDetail"/>
</table>
</common:outlineTable>
<br/>
</s:form>
<s:submit onclick="FormSubmit()" type="image" src="../../common/design/image/btn_save.gif"/>
<s:submit onclick="FormReset()" type="image" src="../../common/design/image/btn_cancel2.gif"/>
<br/><br/>
</div>
</body>
</html>