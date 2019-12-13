package edu.nf.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dwd
 * @date 2019/11/20
 * 用户信息表
 */
public class UserMessage {
    /***
     *   userId;1
     *     userName 用户姓名;1
     *     userSex 性别1
     *      userAge 年龄1
     *     userCall 电话号码1
     *     idCard;身份证1
     *     registerDate;注册时间1
     *      integral;积分1
     *   password;密码
     *     userImg;图片
     *      userStatic;状态
     *      edication:学历
     *      cash:押金
     */
    private String userId;
    private String userName;
    private String userSex;
    private Integer userAge;
    private String userCall;
    private String idCard;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registerDate;
    private Integer integral;
    private String password;
    private BigDecimal cash;
    private String userImg;
    private Integer userStatic;
    private String edication;
    private String userLike;

    public String getUserLike() {
        return userLike;
    }

    public void setUserLike(String userLike) {
        this.userLike = userLike;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserCall() {
        return userCall;
    }

    public void setUserCall(String userCall) {
        this.userCall = userCall;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Integer getUserStatic() {
        return userStatic;
    }

    public void setUserStatic(Integer userStatic) {
        this.userStatic = userStatic;
    }

    public String getEdication() {
        return edication;
    }

    public void setEdication(String edication) {
        this.edication = edication;
    }




}