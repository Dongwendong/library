package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.StaffMessageDao;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.StaffMessageService;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.service.exception.StaffMessageException;
import edu.nf.library.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/21
 */
@Service("staffMessageService")
public class StaffMessageServiceImpl implements StaffMessageService {
    @Autowired
    StaffMessageDao dao;
    @Override
    public void addStaff(StaffMessage staffMessage) {
        try {
            staffMessage.setPassword(MD5Util.encode("123456"));
            dao.addStaff(staffMessage);
        } catch (Exception e) {
            throw new DataBaseException("数据异常！用户添加失败");
        }
    }
    @Override
    public PageInfo<StaffMessage> listStaff(Integer pageNum, Integer pageSize) {
        try {
            List<StaffMessage>staffMessageList= dao.listStaff(pageNum,pageSize);
            PageInfo<StaffMessage>pageInfo=new PageInfo<>(staffMessageList);
            return pageInfo;
        } catch (Exception e) {
            throw new DataBaseException("数据库异常！查询失败！");
        }
    }

    @Override
    public StaffMessage getId(int id) {
        try {
            return dao.getId(id);
        } catch (Exception e) {
           throw new DataBaseException(id+"该id无效！请确认后输入正确的账号。。");
        }
    }

    @Override
    public void updataStaff(StaffMessage message) {
        try {
            System.out.println(message.getStaffName());
            dao.updataStaff(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据异常修改失败！");
        }
    }

    @Override
    public StaffMessage login(Integer id, String password) {
            StaffMessage message= dao.login(id,password);
            if (message!=null){
                return message;
            }
        throw new DataBaseException("你输入的账号有误请重新输入！");
    }

    @Override
    public StaffMessage forGet(Integer id, String phone) {
        StaffMessage message= dao.forGet(id,phone);
        if (message!=null){
            return message;
        }
        throw new DataBaseException("你输入的账号有误请重新输入！");

    }
}