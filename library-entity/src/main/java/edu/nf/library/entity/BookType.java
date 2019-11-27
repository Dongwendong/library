package edu.nf.library.entity;

/**
 * @author dwd
 * @date 2019/11/22
 * 图书类型表
 */
public class BookType {
    private  Integer typeId;
    private String  t_sum;
    private String t_classify;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getT_sum() {
        return t_sum;
    }

    public void setT_sum(String t_sum) {
        this.t_sum = t_sum;
    }

    public String getT_classify() {
        return t_classify;
    }

    public void setT_classify(String t_classify) {
        this.t_classify = t_classify;
    }
}