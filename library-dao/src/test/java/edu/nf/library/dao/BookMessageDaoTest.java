package edu.nf.library.dao;

import edu.nf.library.entity.BookMessage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookMessageDaoTest {

    @Test
    public void addBookMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookMessageDao dao = context.getBean("bookMessageDao", BookMessageDao.class);
        BookMessage message=new BookMessage();
        message.setBookName("Java从入门到精通（第5版）");
        message.setBookType("计算机");

    }
}