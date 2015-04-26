<%--
	※注意！　このjspは古い指定方法なので、importしないでください
	代わりに common:alertTable タグを使用してください
--%>

<%-- 警告用テーブル --%>
	<table class="nothingAlertTable" align="center">
		<tr><td>
			<c:out value="${param.alertStr}"/>
		</td></tr>
	</table>