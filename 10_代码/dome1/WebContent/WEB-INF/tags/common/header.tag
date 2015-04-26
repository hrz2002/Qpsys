<%-- ヘッダー部分の表示 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ tag pageEncoding="UTF-8" %>

<%@ attribute name="menu_id" required="true" %>			<%-- メニューID --%>
		<%-- 日の初期表示 default:今日 --%>
<%@ attribute name="substitute_title" required="false" %> <%-- 代替タイトル（指定された場合はメニューIDのものより優先される） --%>

<%-- Tエリア用 --%>
<c:set var="tBtn_lineNum" value="0" scope="request"/>
<c:set var="tTab2_used" value="false" scope="request"/>
<c:set var="current_line" value="nomal" scope="request"/>

<a name="pageTop"></a>
<table width="100%" border=0 cellspacing=0 cellpadding=0>
	<tr>
		<td align="center" rowspan="1" >
			<table class="title">
				<tr><td class='title'><div style="width:708px; border:0px;"><c:out value="${substitute_title}"/></div></td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table class="tTab">
				<tr>
					<td class="leftSpace"></td>
					
						<jsp:doBody/>
						
						<c:if test="${tBtn_lineNum == 0}">
							<common:tLine/>
						</c:if>
					<td></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<c:choose>
		<c:when test="${tTab2_used == 'false'}">
			<tr><td class="shadow" colspan="2"></td></tr>
		</c:when>
		<c:otherwise>
			<tr><td class="shadow2" colspan="2"></td></tr>
		</c:otherwise>
	</c:choose>
</table>
<br>

<c:remove var="tBtn_lineNum"/>
<c:remove var="tTab2_used"/>
<c:remove var="current_line"/>
