package business.entity;
import java.util.*;

import javax.persistence.*;

import org.apache.openjpa.persistence.*;

import framework.jpa.*;
@Entity
@Table(name = "member",schema="public")
public class Member extends AbstractEntityWithLongId {

    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    private String furigana;

    private String name;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "userSex")
    @Enumerated(EnumType.STRING)
    private Sex userSex;

    private String address;

    private String machi;

    private String mail;
    
    private String tel;

    private String school;
    @Column(name = "schoolDate")
    @Temporal(TemporalType.DATE)
    private Date schoolDate;

    @Column(name = "updateDate")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    private String shikaku;

    @Column(name = "japaneselevel")
    @Enumerated(EnumType.STRING)
    private JapaneseLevel japaneseLevel;

    private String levelbikou;

    /**
     * <p>
     * プロパティ<code>furigana</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>furigana</code>の値
     */
    public String getFurigana() {
        return furigana;
    }

    /**
     * <p>
     * プロパティ<code>furigana</code>の値を設定する。
     * </p>
     *
     * @param furigana プロパティ<code>furigana</code>に設定する値
     */
    public void setFurigana(final String furigana) {
        this.furigana = furigana;
    }

    /**
     * <p>
     * プロパティ<code>name</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>name</code>の値
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * プロパティ<code>name</code>の値を設定する。
     * </p>
     *
     * @param name プロパティ<code>name</code>に設定する値
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * <p>
     * プロパティ<code>birthday</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>birthday</code>の値
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * <p>
     * プロパティ<code>birthday</code>の値を設定する。
     * </p>
     *
     * @param birthday プロパティ<code>birthday</code>に設定する値
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     * <p>
     * プロパティ<code>userSex</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>userSex</code>の値
     */
    public Sex getUserSex() {
        return userSex;
    }

    /**
     * <p>
     * プロパティ<code>userSex</code>の値を設定する。
     * </p>
     *
     * @param userSex プロパティ<code>userSex</code>に設定する値
     */
    public void setUserSex(final Sex userSex) {
        this.userSex = userSex;
    }

    /**
     * <p>
     * プロパティ<code>address</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>address</code>の値
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>
     * プロパティ<code>address</code>の値を設定する。
     * </p>
     *
     * @param address プロパティ<code>address</code>に設定する値
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * <p>
     * プロパティ<code>machi</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>machi</code>の値
     */
    public String getMachi() {
        return machi;
    }

    /**
     * <p>
     * プロパティ<code>machi</code>の値を設定する。
     * </p>
     *
     * @param machi プロパティ<code>machi</code>に設定する値
     */
    public void setMachi(final String machi) {
        this.machi = machi;
    }

    /**
     * <p>
     * プロパティ<code>mail</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>mail</code>の値
     */
    public String getMail() {
        return mail;
    }

    /**
     * <p>
     * プロパティ<code>mail</code>の値を設定する。
     * </p>
     *
     * @param mail プロパティ<code>mail</code>に設定する値
     */
    public void setMail(final String mail) {
        this.mail = mail;
    }

    /**
     * <p>
     * プロパティ<code>tel</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>tel</code>の値
     */
    public String getTel() {
        return tel;
    }

    /**
     * <p>
     * プロパティ<code>tel</code>の値を設定する。
     * </p>
     *
     * @param tel プロパティ<code>tel</code>に設定する値
     */
    public void setTel(final String tel) {
        this.tel = tel;
    }

    /**
     * <p>
     * プロパティ<code>school</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>school</code>の値
     */
    public String getSchool() {
        return school;
    }

    /**
     * <p>
     * プロパティ<code>school</code>の値を設定する。
     * </p>
     *
     * @param school プロパティ<code>school</code>に設定する値
     */
    public void setSchool(final String school) {
        this.school = school;
    }

    /**
     * <p>
     * プロパティ<code>schoolDate</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>schoolDate</code>の値
     */
    public Date getSchoolDate() {
        return schoolDate;
    }

    /**
     * <p>
     * プロパティ<code>schoolDate</code>の値を設定する。
     * </p>
     *
     * @param schoolDate プロパティ<code>schoolDate</code>に設定する値
     */
    public void setSchoolDate(final Date schoolDate) {
        this.schoolDate = schoolDate;
    }

    /**
     * <p>
     * プロパティ<code>updateDate</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>updateDate</code>の値
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * <p>
     * プロパティ<code>updateDate</code>の値を設定する。
     * </p>
     *
     * @param updateDate プロパティ<code>updateDate</code>に設定する値
     */
    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * <p>
     * プロパティ<code>shikaku</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>shikaku</code>の値
     */
    public String getShikaku() {
        return shikaku;
    }

    /**
     * <p>
     * プロパティ<code>shikaku</code>の値を設定する。
     * </p>
     *
     * @param shikaku プロパティ<code>shikaku</code>に設定する値
     */
    public void setShikaku(final String shikaku) {
        this.shikaku = shikaku;
    }


    public JapaneseLevel getJapaneseLevel() {
        return japaneseLevel;
    }

    public void setJapaneseLevel(JapaneseLevel japaneseLevel) {
        this.japaneseLevel = japaneseLevel;
    }

    /**
     * <p>
     * プロパティ<code>levelbikou</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>levelbikou</code>の値
     */
    public String getLevelbikou() {
        return levelbikou;
    }

    /**
     * <p>
     * プロパティ<code>levelbikou</code>の値を設定する。
     * </p>
     *
     * @param levelbikou プロパティ<code>levelbikou</code>に設定する値
     */
    public void setLevelbikou(final String levelbikou) {
        this.levelbikou = levelbikou;
    }

    /**
     * <p>
     * プロパティ<code>birthdayInt</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>birthdayInt</code>の値
     */
    public int getBirthdayInt() {
        int year = 0;
        Calendar cal = Calendar.getInstance(Locale.JAPANESE);
        if (cal == null) {
            cal = Calendar.getInstance();
            final Date date = new Date();
            cal.setTime(date);
        }
        final int now = cal.get(Calendar.YEAR);
        Date br = getBirthday();
        if(br == null){
            br = new Date();
        }
        cal.setTime(br);
        final int birth = cal.get(Calendar.YEAR);
        year = now - birth;
        return year;
    }
    @OneToMany(mappedBy="member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ElementDependent
    @OrderBy("entityId")
    private List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
    /**
     * <p>
     * プロパティ<code>projectInfos</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>projectInfos</code>の値
     */
    public List<ProjectInfo> getProjectInfos() {
        return projectInfos;
    }

    /**
     * <p>
     * プロパティ<code>projectInfos</code>の値を設定する。
     * </p>
     *
     * @param projectInfos プロパティ<code>projectInfos</code>に設定する値
     */
    public void setProjectInfos(List<ProjectInfo> projectInfos) {
        this.projectInfos = projectInfos;
    }
    
}
