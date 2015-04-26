<title>Untitled Document</title>
<common:styleSheet/>
<html>
<head>
</head>
<body>
	<common:header menu_id="dskfkjdsfk" substitute_title="　拡張 ＞ 履歴書一覧">
		<common:tLine>
			<common:tButton name="編集履歴書"  action="edit.action?step=index"/>
		</common:tLine>
	</common:header>
<div align="center">
<common:outlineTable width="90%">
<table class="listTable">
  <col width="120" />
  <col width="152" />
  <col width="76" />
  <col width="92" />
  <col width="93" span="2" />
  <col width="71" span="2" />
  <tr height="40">
    <td scope="col" height="40" colspan="8" >
		　　　　　　　　　　　情報処理技術者名簿　　　　　　　　(作成日
	    <s:date name="member.updateDate" format="yyyy年MM月dd日"/>
	    )
    </td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" width="120">フリガナ</td>
    <td colspan="2" width="228" align="center"><s:property value="member.furigana" /></td>
    <td align="center" class="green" rowspan="2" width="92">生年月日</td>
    <td colspan="2" width="186" align="center"><s:date name="member.birthday" format="yyyy年MM月dd日"/></td>
    <td align="center" class="green" rowspan="2" width="71">性別</td>
    <td rowspan="2" width="71" align="center"><s:property value="member.userSex.label" /></td>
  </tr>
  <tr height="34">
    <td align="center" class="green" height="34" width="120">氏名</td>
    <td colspan="2" width="228" align="center"><s:property value="member.name" /></td>
    <td colspan="2" align="center"><s:property value="member.birthdayInt" />歳</td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28" width="120">現住所</td>
    <td colspan="4" width="413"><s:property value="member.address"/></td>
    <td align="center" class="green" width="93">最寄駅</td>
    <td colspan="2"><s:property value="member.machi" /></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28" width="120">メール</td>
    <td colspan="4" width="413"><a href="mailto:<s:property value="member.mail" />"><s:property value="member.mail" /></a></td>
    <td align="center" class="green" width="93">ＴＥＬ</td>
    <td colspan="2" width="142"><s:property value="member.tel" /></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="28" width="120">最終学歴</td>
    <td colspan="4" width="413"><s:property value="member.school" /></td>
    <td align="center" class="green" width="93">卒業年月</td>
    <td colspan="2"><s:date name="member.schoolDate" format="yyyy年MM月dd日"/></td>
  </tr>
  <tr height="24">
    <td align="center" class="green" height="50" width="120">資格等</td>
    <td colspan="7"><s:property value="member.shikaku" /></td>
  </tr>
  <tr height="28">
    <td align="center" class="green" height="24" width="120">日本語</td>
    <td colspan="7" height="28" width="648" align="left" valign="center">
        　<s:property value="member.japaneseLevel.label" />　　　（備考：<s:property value="member.levelbikou" />）</td>
    </td>
  </tr>
  <tr height="30" align="center">
    <td  class="disable"  colspan="8" height="30">《業務経験》</td>
  </tr>
   <tr height="28" align="left">
    <td  class="disable"  colspan="8">　　　　Ａ．（プロジェクト管理）　　Ｂ．（要件定義）　　　　　　　Ｃ．（基本設計）　　　Ｄ．（詳細設計）　　　Ｅ．（プログラム設計）</td>
  <tr height="28" align="left"><td  class="disable" colspan="8">　　　　Ｆ．（製造・単体テスト）　　Ｇ．（結合・総合テスト）　　Ｈ．（保守・運用）　　　Ｉ．（評価・検証）　　Ｊ．（その他）　　　　</td>
  </tr>
  <tr height="38">
    <td align="center" class="blue" height="38" width="120">業種</td>
    <td align="center" class="blue" colspan="2" width="228">担当業務</td>
    <td align="center" class="blue" width="92">機種／ＯＳ</td>
    <td align="center" class="blue" width="93">言語／ＤＢ</td>
    <td align="center" class="blue" width="93">内容</td>
    <td align="center" class="blue" width="110">作業開始</td>
    <td align="center" class="blue" width="71">作業期間</td>
  </tr>
<s:iterator var="member.projectInfos" value="member.projectInfos" status="rowstatus">
		<s:if test="#rowstatus.odd == true">
	     	<tr class="" height="21">
	    </s:if>
	    <s:else>
	      	<tr class="colored" height="21">
	    </s:else>
			<td align="center" height="63"><s:property value="type"/></td>
		    <td align="left" style="white-space: pre" colspan="2"><s:property value="name"/></td>
		    <td align="center" ><s:property value="sysinfo"/></td>
		    <td align="center" ><s:property value="dbinfo"/></td>
		    <td align="center" ><s:property value="detail"/></td>
		    <td  align="center" nowrap="nowrap"><s:date name="startDate" format="yyyy年MM月"/></td>
		    <td align="center" ><s:property value="dateLength"/>ヶ月</td>
		</tr>
</s:iterator>
</table>
</common:outlineTable>
<br/>
<s:submit onclick="location.href='show.action'" type="image" src="../common/design/image/btn_back.gif"/>
<br/><br/>

</div>
</body>
</html>