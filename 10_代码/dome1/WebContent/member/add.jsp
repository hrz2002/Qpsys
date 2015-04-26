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
	function changeIndexDetail(index) {
		myForm.indexDetail.value = index;
	}
</script>
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
		情報処理技術者名簿
    </td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" nowrap="nowrap">フリガナ</td>
    <td colspan="3" align="left"><s:textfield size="30" name="member.furigana"/></td>
    <td colspan="2" align="center" class="green">生年月日</td>
    <td colspan="3"><sx:datetimepicker id="birthday" language="ja-jp" name="member.birthday"/>
    </td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" width="120">氏名</td>
    <td colspan="3" align="left"><s:textfield size="30" name="member.name" /></td>
    <td colspan="2" align="center" class="green">性別</td>
    <td colspan="3"><s:radio list="userSexMap" name="member.userSex"></s:radio></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28" width="120">現住所</td>
    <td colspan="3" ><s:textfield size="40" name="member.address"/></td>
    <td colspan="2" align="center" class="green"">最寄駅</td>
    <td colspan="3"><s:textfield name="member.machi" /></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28">メール</td>
    <td colspan="3"><s:textfield size="40" name="member.mail"/></td>
    <td colspan="2" align="center" class="green">ＴＥＬ</td>
    <td colspan="3" ><s:textfield name="member.tel"/></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28">最終学歴</td>
    <td colspan="3" ><s:textfield size="40" name="member.school" /></td>
    <td colspan="2" align="center" class="green">卒業年月</td>
    <td colspan="3"><sx:datetimepicker language="ja-jp" name="member.schoolDate" /></td>
  </tr>
  <tr height="24">
    <td align="center" class="green" height="50">資格等</td>
    <td colspan="8"><s:textarea rows="3" cols="60" name="member.shikaku" /></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="24" >日本語</td>
    <td colspan="8">
    	<s:select list="LevelMap" emptyOption="true" name="member.japaneseLevel"></s:select>
		    （備考：  <s:textfield size="20" name="member.levelbikou" />  ）</td>
    </td>
  </tr>
  <tr height="35" align="center">
    <td  class="disable"  colspan="9" height="30">《業務経験》</td>
  </tr>
   <tr height="30" align="left">
    <td  class="disable"  colspan="9">　　　　Ａ．（プロジェクト管理）　　Ｂ．（要件定義）　　　　　　　Ｃ．（基本設計）　　　Ｄ．（詳細設計）　　　Ｅ．（プログラム設計）</td>
  <tr height="30" align="left">
    <td  class="disable" colspan="7">　　　　Ｆ．（製造・単体テスト）　　Ｇ．（結合・総合テスト）　　Ｈ．（保守・運用）　　　Ｉ．（評価・検証）　　Ｊ．（その他）　　　　
    </td>
    <td  colspan="2" class="disable" align="center">
		 <s:submit align="center" action="ajax" type="image" src="../common/design/image/btn_addDetailedState.gif"/>
    </td>

  </tr>
   <tr height="38">
    <td width="6%" align="center" class="colored" height="38">業種</td>
    <td width="10%" align="center" class="colored" colspan="2" nowrap="nowrap">担当業務</td>
    <td width="10%" align="center" class="colored">機種／ＯＳ</td>
    <td width="10%" align="center" class="colored" nowrap="nowrap">言語／ＤＢ</td>
    <td width="10%" align="center" class="colored" nowrap="nowrap">内容</td>
    <td width="10%" align="center" class="colored" nowrap="nowrap">作業開始</td>
    <td width="10%" align="center" class="colored" nowrap="nowrap">作業終了</td>
    <td width="4%" align="center" class="colored" nowrap="nowrap"> 削除 </td>
  </tr>

   <s:iterator value="member.projectInfos" status="status" var="projectInfo">
	    <tr class="" height="21">
			<td height="63"><s:textfield size="10" name="member.projectInfos[%{#status.index}].type" value="%{type}"/></td>
		    <td colspan="2"><s:textfield size="30" name="member.projectInfos[%{#status.index}].name" value="%{name}"/></td>
		    <td><s:textfield  size="10" name="member.projectInfos[%{#status.index}].sysinfo" value="%{sysinfo}"/></td>
		    <td><s:textfield  size="10" name="member.projectInfos[%{#status.index}].dbinfo" value="%{dbinfo}" /></td>
		    <td><s:textfield  size="10" name="member.projectInfos[%{#status.index}].detail" value="%{detail}" /></td>
		    <td><sx:datetimepicker language="zh-cn" name="member.projectInfos[%{#status.index}].startDate" value="%{startDate}" formatLength="short" /></td>
		    <td><sx:datetimepicker language="zh-cn" name="member.projectInfos[%{#status.index}].endDate" value="%{endDate}" formatLength="short"  /></td>
			<td>
				<s:submit action="del_detail" onclick="changeIndexDetail(%{#status.index})" type="image" src="../common/design/image/btn_delete_s.gif"></s:submit>
			</td>
		</tr>
	</s:iterator>
  	<s:hidden name="indexDetail"/>
</table>
</common:outlineTable>
<br/>
</s:form>
<s:submit onclick="FormSubmit()" type="image" src="../common/design/image/btn_save.gif"/>
<s:submit onclick="FormReset()" type="image" src="../common/design/image/btn_cancel2.gif"/>
<br/><br/>
</div>
</body>
</html>