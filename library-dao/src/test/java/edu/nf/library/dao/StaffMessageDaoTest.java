package edu.nf.library.dao;

import edu.nf.library.entity.StaffMessage;
import edu.nf.library.util.MD5Util;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StaffMessageDaoTest {

    @Test
    public void listStaff() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
        List<StaffMessage> staffMessageList = dao.listStaff(1, 5);
        System.out.println(staffMessageList.size());
    }

    @Test
    public void addStaff() {
        StaffMessage message = new StaffMessage();
        message.setStaffName("东京");
        message.setStaffCal("15787466432");
        message.setLinkmanName("赵折");
        message.setLinkmanCall("15693495391");
        message.setDuty("亲");
        message.setBankCard("5437548536749463853");
        message.setEducation("高中");
        message.setStaffStatic(0);
        message.setStaffImg("default.jpg");
        message.setStaffAddress("江苏省");
        message.setStaffAge(19);
        message.setStaffSex("男");
        message.setStaffIdcard("543235199533315255");
        message.setPassword(MD5Util.encode("123321"));
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
        dao.addStaff(message);
    }

    @Test
    public void getLisetStaff() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);

        StaffMessage message = new StaffMessage();

        message.setDuty("前台人员");
        List<StaffMessage> list = dao.getLisetStaff( 1,4,message);
        System.out.println(list.size());
    }

    @Test
    public void getId() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
      StaffMessage message=   dao.getId(10000);
        System.out.println(message.getStaffName());
    }

    @Test
    public void updataStaff() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
        StaffMessage message=new StaffMessage();
        StaffMessage message1=dao.getId(10016);
        message1.setStaffName("张三");
        dao.updataStaff(message1);
    }

    @Test
    public void login() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
       StaffMessage message=dao.login(10000,"111111");
        System.out.println(message);

    }

    @Test
    public void forGet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        StaffMessageDao dao = context.getBean("staffMessageDao", StaffMessageDao.class);
        StaffMessage message=dao.forGet(10000,"15601804843");
        System.out.println(message);
    }
}