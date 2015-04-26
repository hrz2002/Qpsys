<title>MM</title>
<common:styleSheet/>
<html>
<head>
</head>
<body>
	<common:header menu_id="dskfkjdsfk" substitute_title="　MM ＞客户主数据">
		<common:tLine>
			<common:tButton name="新追加"  action="detail.action"/>
			<common:tButton name="导出数据"  action="detail.action"/>
		</common:tLine>
	</common:header>
 <s:actionerror />
<div align="center">
<common:outlineTable width="90%">
<table class="listTable">
 	<th class="head" scope="col">NO</th>
	<th class="head" scope="col">代表</th>
	<th class="head" scope="col">邮件地址</th>
	<th class="head" scope="col">电话</th>
	<th class="head" scope="col">公司地址</th>
	<th class="head" scope="col">备注</th>
	<th class="head" scope="col">操作</th>
</tr>
</thead>
<tbody>
	<s:iterator value="customers" status="rowstatus">
		<s:if test="#rowstatus.odd == true">
	     	<tr class="">
	    </s:if>
	    <s:else>
	      	<tr class="colored">
	    </s:else>
		<td class="right" ><s:property value="entityId"/></td>
		<td class="center"><s:property value="name"/></td>
		<td class="center"><s:property value="mail"/></td>
		<td class="center"><s:property value="tel"/></td>
		<td class="center"><s:property value="address"/></td>
		<td class="center"><s:property value="other"/></td>
		<td class="center">
			<input type="image" src="../../common/design/image/btn_detail_s.gif" onClick="location.href='detail.action?entityId=<s:property value="entityId"/>'">
			<input type="image" src="../../common/design/image/btn_edit_s.gif" onClick="location.href='edit.action?step=edit&entityId=<s:property value="entityId"/>'">
			<input type="image" src="../../common/design/image/btn_delete_s.gif" onClick="location.href='del.action?entityId=<s:property value="entityId"/>'">
		</td>
		</tr>
	</s:iterator>
</tbody>
</table>
</common:outlineTable>
</div>
</body>
</html>
