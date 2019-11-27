package edu.nf.library.service;

import com.github.pagehelper.PageInfo;
import edu.nf.library.entity.StaffMessage;

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

}