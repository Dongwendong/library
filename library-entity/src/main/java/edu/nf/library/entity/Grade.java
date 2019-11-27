package edu.nf.library.entity;

/**
 * @author dwd
 * @date 2019/11/20
 * 违约处罚表
 */
public class Grade {
    /***
     * gradeId 处罚id
     * userId 用户id
     * bookId 书籍id
     * reason 处罚原因
     * result 处罚结果
     * staffId  管理员id
     */
    private Integer gradeId;
    private Integer userId;
    private Integer bookId;
    private String reason;
    private String  result;
    private Integer staffId;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}