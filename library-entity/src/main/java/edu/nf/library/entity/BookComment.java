package edu.nf.library.entity;

/**
 * @author dwd
 * @date 2019/11/20
 * 图书评论表
 */
public class BookComment {
    /***
     * 评论id
     */
    private Integer  commentId;
    /***
     * 用户id
     */
    private Integer userId;
    /***
     * 图书id
     */
    private Integer bookId;
    /***
     * 评论
     */
    private String  remark;
    /****
     * 书籍评分
     */
    private double grade;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}