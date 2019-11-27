package edu.nf.library.entity;

import sun.dc.pr.PRError;

import java.sql.Date;

/**
 * @author dwd
 * @date 2019/11/20
 * 图书借阅表
 * borrowId 借书id
 * userId 用户id
 * bookId 图书id
 * borrowDate 借书时间
 * returnDate 还书时间
 * predictData 预计还书时间
 * gradeId 处罚id
 */
public class BorrowBook {
    private  String borrowId;
    private Integer userId;
    private Integer bookId;
    private Date borrowDate;
    private Date returnDate;
    private Date predictData;
    private Integer gradeId;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getPredictData() {
        return predictData;
    }

    public void setPredictData(Date predictData) {
        this.predictData = predictData;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
}