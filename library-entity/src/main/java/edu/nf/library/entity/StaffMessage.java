package edu.nf.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author dwd
 * @date 2019/11/20
 * 管理员信息表
 */
public class StaffMessage {
    /***
     * 管理员id
     */
    private Integer staffId;
    /***
     * 管理员姓名
     */
    @NotEmpty(message = "{StaffMessage.staffName}")
    private String staffName;
    /***
     * 管理员手机号
     */
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "{StaffMessage.staffCal}")
    private String staffCal;
    /***
     *  管理员家庭住址
     */
    @NotEmpty(message = "{StaffMessage.staffAddress}")
    private String staffAddress;
    /***
     *  管理员身份证
     */
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "{StaffMessage.staffIdcard}")
    private String staffIdcard;
    /***
     * 管理员性别
     */
    @NotEmpty(message = "{StaffMessage.staffSex}")
    private String staffSex;
    /***
     * 管理员年龄
     */
    @NotNull(message = "请输入年龄")
    private Integer staffAge;
    /***
     *  管理员图片
     */

    private String staffImg;
    /***
     * 管理员状态
     */
    private Integer staffStatic;
    /***
     *  管理员学历
     */
    private String education;
    /***
     * 管理员入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotNull(message = "{StaffMessage.entryDate}")
    private Date entryDate;
    /***
     *   管理员职务
     */
    private String duty;
    /***
     *   管理员紧急联系人姓名
     */
    @NotEmpty(message = "{StaffMessage.linkmanName}")
    private String linkmanName;
    /***
     *  管理员紧急联系人手机号
     */
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "{StaffMessage.linkmanCall}")
    private String linkmanCall;
    /***
     * 管理员银行号
     */
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "{StaffMessage.bankCard}")
    private String bankCard;
    /***
     * 管理员密码
     */
    private String password;
    private int operating;

    public int getOperating() {
        return operating;
    }

    public void setOperating(int operating) {
        this.operating = operating;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffCal() {
        return staffCal;
    }

    public void setStaffCal(String staffCal) {
        this.staffCal = staffCal;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffImg() {
        return staffImg;
    }

    public void setStaffImg(String staffImg) {
        this.staffImg = staffImg;
    }

    public Integer getStaffStatic() {
        return staffStatic;
    }

    public void setStaffStatic(Integer staffStatic) {
        this.staffStatic = staffStatic;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanCall() {
        return linkmanCall;
    }

    public void setLinkmanCall(String linkmanCall) {
        this.linkmanCall = linkmanCall;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StaffMessage{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffCal='" + staffCal + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                ", staffIdcard='" + staffIdcard + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", staffAge=" + staffAge +
                ", staffImg='" + staffImg + '\'' +
                ", staffStatic=" + staffStatic +
                ", education='" + education + '\'' +
                ", entryDate=" + entryDate +
                ", duty='" + duty + '\'' +
                ", linkmanName='" + linkmanName + '\'' +
                ", linkmanCall='" + linkmanCall + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", password='" + password + '\'' +
                ", operating=" + operating +
                '}';
    }
}