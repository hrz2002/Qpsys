<title>情報処理技術者　一覧</title>
<common:styleSheet/>
<html>
<head>
</head>
<body>
	<common:header menu_id="dskfkjdsfk" substitute_title="　拡張 ＞情報処理技術者　一覧">
		<common:tLine>
			<common:tButton name="新規履歴書"  action="detail.action"/>
		</common:tLine>
	</common:header>
 <s:actionerror />
<div align="center">
<common:outlineTable width="90%">
<table class="listTable">
 	<th class="head" scope="col">社員コート</th>
	<th class="head" scope="col">名前</th>
	<th class="head" scope="col">性別</th>
	<th class="head" scope="col">操作</th>
</tr>
</thead>
<tbody>
	<s:iterator value="members" status="rowstatus">
		<s:if test="#rowstatus.odd == true">
	     	<tr class="">
	    </s:if>
	    <s:else>
	      	<tr class="colored">
	    </s:else>
		<td class="right"><s:property value="entityId"/></td>
		<td class="center"><s:property value="name"/></td>
		<td class="center"><s:property value="userSex.label"/></td>
		<td class="center">
			<input type="image" src="../common/design/image/btn_detail_s.gif" onClick="location.href='detail.action?entityId=<s:property value="entityId"/>'">
			<input type="image" src="../common/design/image/btn_edit_s.gif" onClick="location.href='edit.action?step=edit&entityId=<s:property value="entityId"/>'">
			<input type="image" src="../common/design/image/btn_delete_s.gif" onClick="location.href='del.action?entityId=<s:property value="entityId"/>'">
		</td>
		</tr>
	</s:iterator>
</tbody>
</table>
</common:outlineTable>
</div>
</body>
</html>
