<%-- Tタブ または Tタブ２を配置する --%>
<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="name" required="true" %>		<%-- タブ名称 --%>
<%@ attribute name="condition" required="true" %>	<%-- タブがON状態になる条件 --%>
<%@ attribute name="action" required="true" %>		<%-- タブが押された際のアクション --%>


<c:choose>
	<c:when test="${current_line == 'nomal'}"><%-- Tタブを配置 --%>
		<c:choose>
			<c:when test="${condition}">
				<td class="on_L">
					<c:choose>
						<c:when test="${fn:length(name) <= 4}">
							<td align="center" class="on_C" width="64"></td>
						</c:when>
						<c:otherwise>
							<td align="center" class="on_C" width="${fn:length(name)*16}"></td>
						</c:otherwise>
					</c:choose>
					<c:out value="${name}"/>
				</td>
				<td class="on_R"></td>
			</c:when>
			<c:otherwise>
				<td class="off_L" onClick="${action}">
					<c:choose>
						<c:when test="${fn:length(name) <= 4}">
							<td align="center" class="off_C" onClick="${action}" width="64"></td>
						</c:when>
						<c:otherwise>
							<td align="center" class="off_C" onClick="${action}" width="${fn:length(name)*16}"></td>
						</c:otherwise>
					</c:choose>
					<c:out value="${name}"/>
				</td>
				<td class="off_R" onClick="${action}"></td>
			</c:otherwise>
		</c:choose>
	</c:when>
	
	<c:when test="${current_line == 'tTab2'}"><%-- Tタブ２を配置 --%>
		<c:choose>
			<c:when test="${condition}">
				<c:choose>
					<c:when test="${fn:length(name) <= 4}">
						<td align="center" class="on" width="70"></td>
					</c:when>
					<c:otherwise>
						<td align="center" class="on" width="${fn:length(name)*16}"></td>
					</c:otherwise>
				</c:choose>
				<c:out value="${name}"/>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${fn:length(name) <= 4}">
						<td align="center" class="off" onClick="${action}" width="70"></td>
					</c:when>
					<c:otherwise>
						<td align="center" class="off" onClick="${action}" width="${fn:length(name)*16}"></td>
					</c:otherwise>
				</c:choose>
				<c:out value="${name}"/>
			</c:otherwise>
		</c:choose>
	</c:when>
</c:choose>