<%-- Tボタンを追加 --%>
<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="name" required="true" %>		<%-- ボタン名称 --%>
<%@ attribute name="condition" required="false" %>	<%-- ボタンが表示される条件　default:常に表示 --%>
<%@ attribute name="action" required="true" %>		<%-- ボタンが押された際のアクション、またはジャンプ先URL --%>
<%@ attribute name="actionType" required="false" %>	<%-- 上記アクションの種類　onClick（スクリプト実行） または href（ページジャンプ） を指定　default:href --%>

<c:if test="${condition == null || condition == true}">
	
	<td class="tb_L"></td>
	
	<c:if test="${actionType == 'href' || actionType == null}">
		<c:set var="action" value="location.href='${action}'"/>
	</c:if>
	<td class="tb_C" align="center" onClick="${action}" width="80">
	
		<nobr><c:out value="${name}"/></nobr>
	</td>
	<td class="tb_R"></td>

</c:if>