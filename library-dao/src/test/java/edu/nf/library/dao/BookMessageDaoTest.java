package edu.nf.library.dao;

import edu.nf.library.entity.BookMessage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookMessageDaoTest {

    @Test
    public void addBookMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookMessageDao dao = context.getBean("bookMessageDao", BookMessageDao.class);
        BookMessage message = new BookMessage();
        message.setBookName("Java从入门到精通（第5版）");
        message.setBookType("计算机");

    }

    @Test
    public void listBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookMessageDao dao = context.getBean("bookMessageDao", BookMessageDao.class);
        List<BookMessage> messageList = dao.listBook(1, 3);
        System.out.println(messageList.size());
    }

    @Test
    public void getIdMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookMessageDao dao = context.getBean("bookMessageDao", BookMessageDao.class);
        BookMessage message = dao.getIdMessage(10014);
        System.out.println(message.getKind().getT_classify());
    }

    @Test
    public void updateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookMessageDao dao = context.getBean("bookMessageDao", BookMessageDao.class);
        BookMessage m = new BookMessage();
        m.setBookName("qqq");
        m.setBookId(10010);
        BigDecimal bigDecimal = new BigDecimal("22");
        m.setBookPrice(bigDecimal);
        m.setBookType("空間");
        m.setPublishing("publishing");
        m.setSuitable("sss");
        dao.updateBook(m);
    }
}