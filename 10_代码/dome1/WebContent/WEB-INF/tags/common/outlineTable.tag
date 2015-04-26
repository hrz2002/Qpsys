<%-- テーブル外枠 --%>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="width" required="false" %>

<table width="${width}" class="outline">
	<tr><td class="outline_leftTop"></td><td class="outline_top"></td><td class="outline_rightTop"></td></tr>
	<tr><td class="outline_left"></td><td class="mainCell">
	
		<jsp:doBody/>
		
	</td><td class="outline_right"></td></tr>
	<tr><td class="outline_leftBottom"></td><td class="outline_bottom"></td><td class="outline_rightBottom"></td></tr>
</table>