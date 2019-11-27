package edu.nf.library.dao;

import edu.nf.library.entity.StaffMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/21
 */
@Repository("staffMessageDao")
public interface StaffMessageDao {
    /***
     * 添加用户
     * @param staffMessage
     */
    void addStaff(StaffMessage staffMessage);
    /***
     * 查询全部用户并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<StaffMessage> listStaff(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    List<StaffMessage> getLisetStaff(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,StaffMessage message);
    StaffMessage getId(int id);
    void updataStaff(StaffMessage message);
}