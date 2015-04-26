<%-- ヘッダー部分の表示 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ tag pageEncoding="UTF-8" %>

<%@ attribute name="menu_id" required="true" %>			<%-- メニューID --%>
		<%-- 日の初期表示 default:今日 --%>
<%@ attribute name="substitute_title" required="false" %> 

<a name="pageTop"></a>
<table class="title2" width="100%" border=0 cellspacing=0 cellpadding=0>
	<tr>
		<td align="center" rowspan="1" >
			<table class="title2">
				<tr><td class="title2"><div style="width:708px; border:0px;"><c:out value="${substitute_title}"/></div></td></tr>
			</table>
		</td>
	</tr>
</table>
<br>

