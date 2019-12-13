package edu.nf.library.service;

import com.github.pagehelper.PageInfo;
import edu.nf.library.entity.BorrowBook;
import edu.nf.library.entity.StaffMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/21
 */
public interface StaffMessageService {
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

    PageInfo<StaffMessage> listStaff(Integer pageNum, Integer pageSize);
    StaffMessage getId(int id);
    void updataStaff(StaffMessage message);
    StaffMessage login(Integer id ,String password);
    StaffMessage forGet(Integer id ,String phone);
    void updatePassword(Integer id,String password);
    PageInfo<StaffMessage> likeName(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize , String name, String duty);
}