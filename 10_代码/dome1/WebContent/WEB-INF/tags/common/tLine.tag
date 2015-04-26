<%-- ヘッダーにTボタン等を配置するためのラインを追加する --%>
<%-- なお、ヘッダーにTボタンが無い場合は、このタグを指定する必要は無い --%>
<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type" required="false"%>
<%-- ラインの種類 (type)--%>
<%-- nomal(default)	:普通のライン --%>
<%-- top			:普通のラインの縦幅が複数行分になるときの、上層ライン --%>
<%-- middle			:普通のラインの縦幅が複数行分になるときの、中層ライン --%>
<%-- bottom			:普通のラインの縦幅が複数行分になるときの、下層ライン --%>
<%-- tTab2			:Tタブ２用のライン --%>
<%-- information	:情報表示のためのライン --%>

<%@ attribute name="rendered" required="false"%>

<c:if test="${rendered == null || rendered == true}">

	<c:if test="${type == null}">
		<c:set var="type" value="nomal" />
	</c:if>

	<td class="rightSpace"></td>
	</tr>
	</table>
	</td>
	</tr>

	<c:if
		test="${tBtn_lineNum == 0 && (type == 'tTab2' || type == 'information')}">
		<tr>
			<td>
			<table class="tBtn tBtn_base_nomal">
				<tr>
					<td width="1"></td>
					<td class="rightSpace"></td>
				</tr>
			</table>
			</td>
		</tr>
		<c:set var="tBtn_lineNum" value="${tBtn_lineNum + 1}" scope="request" />
	</c:if>

	<tr>
		<c:choose>
			<c:when test="${tBtn_lineNum == 0}">
				<%-- １行目 --%>
				<td>
			</c:when>
			<c:otherwise>
				<%-- ２行目以降 --%>
				<td colspan="2">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when
				test="${type == 'nomal' || type == 'top' || type == 'middle' || type == 'bottom'}">
				<table class="tBtn tBtn_base_${type}">
					<tr>
						<td width="1"></td>
						</c:when>
						<c:when test="${type == 'tTab2'}">
							<c:set var="tTab2_used" value="true" scope="request" />
							<table class="tTab2">
								<tr>
									</c:when>
									<c:when test="${type == 'information'}">
										<c:set var="tTab2_used" value="true" scope="request" />
										<table class="tBtn_information">
											<tr>
												<td width="1"></td>
												</c:when>
												</c:choose>
												<c:set var="current_line" value="${type}" scope="request" />
												<c:set var="tBtn_lineNum" value="${tBtn_lineNum + 1}"
													scope="request" />

												<jsp:doBody />

												</c:if>