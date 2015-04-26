package business.action;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.util.Base64;
import org.apache.struts2.ServletActionContext;

import business.entity.JapaneseLevel;
import business.entity.Member;
import business.entity.ProjectInfo;
import business.entity.Sex;
import business.service.*;

import com.opensymphony.xwork2.*;

import framework.jpa.EntityId;

public class MemberAction extends ActionSupport {

    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * プロパティ<code>service</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>service</code>の値
     */

    private long entityId;

    private String step;

    private int indexDetail;

    private Member member;

    private List<Member> members;

    /**
     * <p>
     * プロパティ<code>entityId</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>entityId</code>の値
     */
    public long getEntityId() {
        return entityId;
    }

    /**
     * <p>
     * プロパティ<code>entityId</code>の値を設定する。
     * </p>
     *
     * @param entityId プロパティ<code>entityId</code>に設定する値
     */
    public void setEntityId(final long entityId) {
        this.entityId = entityId;
    }

    /**
     * <p>
     * プロパティ<code>step</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>step</code>の値
     */
    public String getStep() {
        return step;
    }

    /**
     * <p>
     * プロパティ<code>indexDetail</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>indexDetail</code>の値
     */
    public int getIndexDetail() {
        return indexDetail;
    }

    /**
     * <p>
     * プロパティ<code>indexDetail</code>の値を設定する。
     * </p>
     *
     * @param indexDetail プロパティ<code>indexDetail</code>に設定する値
     */
    public void setIndexDetail(final int indexDetail) {
        this.indexDetail = indexDetail;
    }

    /**
     * <p>
     * プロパティ<code>step</code>の値を設定する。
     * </p>
     *
     * @param step プロパティ<code>step</code>に設定する値
     */
    public void setStep(final String step) {
        this.step = step;
    }

    /**
     * <p>
     * プロパティ<code>member</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>member</code>の値
     */
    public Member getMember() {
        return member;
    }

    /**
     * <p>
     * プロパティ<code>member</code>の値を設定する。
     * </p>
     *
     * @param member プロパティ<code>member</code>に設定する値
     */
    public void setMember(final Member member) {
        final List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
        projectInfos.addAll(member.getProjectInfos());
        member.setProjectInfos(projectInfos);
        this.member = member;
    }

    /**
     * <p>
     * プロパティ<code>members</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>members</code>の値
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * <p>
     * プロパティ<code>members</code>の値を設定する。
     * </p>
     *
     * @param members プロパティ<code>members</code>に設定する値
     */
    public void setMembers(final List<Member> members) {
        this.members = members;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Map getUserSexMap() {
        final Map userSexMap = new LinkedHashMap();
        userSexMap.put(Sex.MALE, Sex.MALE.getLabel());
        userSexMap.put(Sex.FEMALE, Sex.FEMALE.getLabel());
        return userSexMap;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Map getLevelMap() {
        final Map levelMap = new LinkedHashMap();
        levelMap.put(JapaneseLevel.A, JapaneseLevel.A.getLabel());
        levelMap.put(JapaneseLevel.B, JapaneseLevel.B.getLabel());
        levelMap.put(JapaneseLevel.C, JapaneseLevel.C.getLabel());
        levelMap.put(JapaneseLevel.D, JapaneseLevel.D.getLabel());
        return levelMap;
    }

    //===========================Actions==================start
    @Override
    public void validate() {
        clearFieldErrors();
        clearActionErrors();
    }

    public String PersistenceException() throws Exception {
        return Action.SUCCESS;
    }

    public String save() throws Exception {
        final Member me = getMember();
        if (me.getFurigana() == null || me.getFurigana().equals("")) {
            addFieldError("furigana", "フリガナに値が入力されていません。");
        }
        if (me.getName() == null || me.getName().equals("")) {
            addFieldError("name", "氏名に値が入力されていません。");
        }
        if (getFieldErrors().size() > 0) {
            return Action.INPUT;
        }
        me.setUpdateDate(getNowDate());
        final Member ret = memberService.save(me);
        if (ret != null && getStep() != null && !getStep().equals("edit")) {
            this.member = ret;
            return Action.LOGIN;
        }
        return Action.SUCCESS;
    }

    public String del() {
        try {
            memberService.remove(EntityId.valueOf(entityId));
        } catch (final Exception e) {
            addActionError(e.getMessage());
            return Action.ERROR;
        }

        return Action.SUCCESS;
    }

    public String edit() throws Exception {
        final EntityId id = EntityId.valueOf(entityId);
        final Member me = memberService.findByEntityId(id);
        setMember(me);
        return Action.SUCCESS;
    }

    public String detail() throws Exception {
        if (entityId == 0) {
            final Member me = new Member();
            me.setUserSex(Sex.MALE);

            me.setBirthday(getNowDate());
            me.setSchoolDate(getNowDate());
            me.setUpdateDate(getNowDate());

            setMember(me);
            return Action.INPUT;
        }
        final EntityId id = EntityId.valueOf(entityId);
        final Member me = memberService.findByEntityId(id);
        setMember(me);
        return Action.SUCCESS;
    }

    public String show() throws Exception {
        clear();
        final List<Member> A = memberService.findAll();
        setMembers(A);
        return Action.SUCCESS;
    }

    public String back() throws Exception {
        if (getStep() != null && getStep().equals("index")) {
            final Member me = memberService.findByEntityId(this.member.getEntityId());
            setMember(me);
            return Action.LOGIN;
        }
        return Action.SUCCESS;
    }

    public String ajax() {
        final ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setStartDate(getNowDate());
        projectInfo.setEndDate(getNowDate());
        projectInfo.setMember(this.member);
        if (this.member.getProjectInfos() == null) {
            final List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
            projectInfos.add(projectInfo);
            this.member.setProjectInfos(projectInfos);
            this.member.getProjectInfos().add(projectInfo);
        } else {
            this.member.getProjectInfos().add(projectInfo);
        }
        return Action.SUCCESS;
    }

    public String del_detail() throws Exception {
        this.member.getProjectInfos().remove(this.indexDetail);
        return Action.SUCCESS;
    }

    public String getContentDisposition() throws IOException {
        final String filename = "履歴書_" + this.member.getName().replace(" ", "").replace("　", "") + ".PDF";
        //final String dispositionHeaderValue = String.format("%s; filename=\"%s\"", "attachment", URLEncoder.encode(filename, "UTF-8"));
        //final String dispositionHeaderValue = "attachment; filename=\"" + MimeUtility.encodeText(filename) + "\"";

        //☆エンコード ③
        //final String dispositionHeaderValue = MimeUtility.encodeText(filename, "UTF-8", dispositionHeaderValue);

        final String dispositionHeaderValue = "attachment; filename=\"" + encodeFileName(filename) + "\"";
        return dispositionHeaderValue;
    }

    public static String encodeFileName(String fileName) throws UnsupportedEncodingException {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String agent = request.getHeader("USER-AGENT");
    	    if (null != agent && -1 != agent.indexOf("MSIE")) {
    	       return URLEncoder.encode(fileName, "UTF8");
    	   }else if (null != agent && -1 != agent.indexOf("Mozilla")) {
    	        return "=?UTF-8?B?"+(new String(Base64.encode(fileName.getBytes("UTF-8"))))+"?=";
    	    } else {
    	        return fileName;
    	  }
    }

    private InputStream inputStreamPDF;

    public InputStream getInputStreamPDF() {
        return inputStreamPDF;
    }

    public void setInputStreamPDF(final InputStream inputStreamPDF) {
        this.inputStreamPDF = inputStreamPDF;
    }

    //===========================Actions==================end
    private Date getNowDate() {
        final Calendar cal = Calendar.getInstance(Locale.JAPANESE);
        final Date date = new Date();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private void clear() {
        this.entityId = 0;
        this.step = "";
        this.member = null;
        this.members = null;
    }

    //===========================Service==================
    public MemberAction(final MemberService memberService) {
        this.memberService = memberService;
    }

    private final MemberService memberService;
}
