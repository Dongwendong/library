package edu.nf.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dwd
 * @date 2019/11/20
 * 图书信息表
 */
public class BookMessage {
    /***
     * 图书id
     */
    private Integer bookId;
    /***
     * 图书名称
     */
    private String bookName;
    /***
     * 图书类型
     */
    private String bookType;
    /***
     * 图书价格
     */
    private BigDecimal bookPrice;
    /***
     * 出版时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bookDate;
    /***
     * 出版社
     */
    private String publishing;
    /***
     * 图书状态
     */
    private  Integer bookStatic;
    /***
     * 图书图片
     */
    private String bookImg;
    /***
     * 图书简介
     */
    private String bookBrief;
    /***
     * 剩余本数
     */
    private Integer  bookResidue;
    /***
     * 图书的购买时间
     */


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date buyingDate;
    /***
     * 图书作者
     */
    private String author;
    /***
     * 适用人群
     */
    private String suitable;
    private BookType kind;

    public BookType getKind() {
        return kind;
    }

    public void setKind(BookType kind) {
        this.kind = kind;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    /***
     * 图书评论
     */

    private List<BookComment>bookCommentList=new ArrayList<>();

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public Integer getBookStatic() {
        return bookStatic;
    }

    public void setBookStatic(Integer bookStatic) {
        this.bookStatic = bookStatic;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookBrief() {
        return bookBrief;
    }

    public void setBookBrief(String bookBrief) {
        this.bookBrief = bookBrief;
    }

    public Integer getBookResidue() {
        return bookResidue;
    }

    public void setBookResidue(Integer bookResidue) {
        this.bookResidue = bookResidue;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookComment> getBookCommentList() {
        return bookCommentList;
    }

    public void setBookCommentList(List<BookComment> bookCommentList) {
        this.bookCommentList = bookCommentList;
    }
}