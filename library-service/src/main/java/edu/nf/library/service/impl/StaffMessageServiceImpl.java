package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.StaffMessageDao;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.StaffMessageService;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.service.exception.StaffMessageException;
import edu.nf.library.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger= LoggerFactory.getLogger(ForbiddenServiceImpl.class);

    @Override
    public void addStaff(StaffMessage staffMessage) {
        try {
            staffMessage.setPassword(MD5Util.encode("123456"));
            dao.addStaff(staffMessage);
            logger.info("添加管理员："+staffMessage.getStaffId());
        } catch (Exception e) {
            throw new DataBaseException("数据异常！管理员添加失败");
        }
    }

    @Override
    public PageInfo<StaffMessage> listStaff(Integer pageNum, Integer pageSize) {
        try {
            List<StaffMessage> staffMessageList = dao.listStaff(pageNum, pageSize);
            PageInfo<StaffMessage> pageInfo = new PageInfo<>(staffMessageList);
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
            throw new DataBaseException(id + "该id无效！请确认后输入正确的账号。。");
        }
    }

    @Override
    public void updataStaff(StaffMessage message) {
        try {
            System.out.println(message.getStaffName());
            dao.updataStaff(message);
            logger.info("账号为："+message.getStaffId()+"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据异常修改失败！");
        }
    }

    @Override
    public StaffMessage login(Integer id, String password) {
        password = MD5Util.encode(password);
        StaffMessage message = dao.login(id, password);
        if (message != null) {
            logger.info(id+":登录成功");
            return message;
        }
        throw new DataBaseException("你输入的账号有误请重新输入！");
    }

    @Override
    public StaffMessage forGet(Integer id, String phone) {
        StaffMessage message = dao.forGet(id, phone);
        if (message != null) {
            return message;
        }
        throw new DataBaseException("你输入的账号有误请重新输入！");
    }

    @Override
    public void updatePassword(Integer id, String password) {
        try {
            password = MD5Util.encode(password);
            dao.updatePassword(id, password);
            logger.info("账号为："+id+",密码修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据异常！密码修改失败");
        }
    }
    @Override
    public PageInfo<StaffMessage> likeName(Integer pageNum, Integer pageSize , String name, String duty) {
        List<StaffMessage> messageList = dao.likeName(pageNum,pageSize,name, duty);
        if (messageList.size()>0){
            PageInfo<StaffMessage>pageInfo=new PageInfo<>(messageList);
            return pageInfo;
        }
        throw new DataBaseException("没有找到该用户信息,请确认信息后输入");
    }
}