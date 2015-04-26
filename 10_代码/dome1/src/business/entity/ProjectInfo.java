package business.entity;

import java.util.*;

import javax.persistence.*;

import framework.jpa.*;
@Entity
@Table(name = "projectInfo",schema="public")
public class ProjectInfo extends AbstractEntityWithLongId {
    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;

    private String type;

    private String name;

    private String sysinfo;

    private String dbinfo;

    private String detail;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEMBER_ENTITYID")
    private Member member;

    /**
     * <p>
     * プロパティ<code>birthdayInt</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>birthdayInt</code>の値
     */
    public int getDateLength() {

        final Calendar cal = Calendar.getInstance(Locale.JAPANESE);
        cal.setTime(getStartDate());
        final Calendar cal2 = Calendar.getInstance(Locale.JAPANESE);
        cal2.setTime(getEndDate());

        final int yearLength = cal2.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        final int monthLength = cal2.get(Calendar.MONTH) - cal.get(Calendar.MONTH);
        final int ret = yearLength * 12 + monthLength+1;
        return ret;
    }

    /**
     * <p>
     * プロパティ<code>type</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>type</code>の値
     */
    public String getType() {
        return type;
    }

    /**
     * <p>
     * プロパティ<code>type</code>の値を設定する。
     * </p>
     *
     * @param type プロパティ<code>type</code>に設定する値
     */
    public void setType(final String type) {
        this.type = type;
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
     * プロパティ<code>sysinfo</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>sysinfo</code>の値
     */
    public String getSysinfo() {
        return sysinfo;
    }

    /**
     * <p>
     * プロパティ<code>sysinfo</code>の値を設定する。
     * </p>
     *
     * @param sysinfo プロパティ<code>sysinfo</code>に設定する値
     */
    public void setSysinfo(final String sysinfo) {
        this.sysinfo = sysinfo;
    }

    /**
     * <p>
     * プロパティ<code>dbinfo</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>dbinfo</code>の値
     */
    public String getDbinfo() {
        return dbinfo;
    }

    /**
     * <p>
     * プロパティ<code>dbinfo</code>の値を設定する。
     * </p>
     *
     * @param dbinfo プロパティ<code>dbinfo</code>に設定する値
     */
    public void setDbinfo(final String dbinfo) {
        this.dbinfo = dbinfo;
    }

    /**
     * <p>
     * プロパティ<code>detail</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>detail</code>の値
     */
    public String getDetail() {
        return detail;
    }

    /**
     * <p>
     * プロパティ<code>detail</code>の値を設定する。
     * </p>
     *
     * @param detail プロパティ<code>detail</code>に設定する値
     */
    public void setDetail(final String detail) {
        this.detail = detail;
    }

    /**
     * <p>
     * プロパティ<code>startDate</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>startDate</code>の値
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * <p>
     * プロパティ<code>startDate</code>の値を設定する。
     * </p>
     *
     * @param startDate プロパティ<code>startDate</code>に設定する値
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * <p>
     * プロパティ<code>endDate</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>endDate</code>の値
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * <p>
     * プロパティ<code>endDate</code>の値を設定する。
     * </p>
     *
     * @param endDate プロパティ<code>endDate</code>に設定する値
     */
    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
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
        this.member = member;
    }

}
