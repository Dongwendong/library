package edu.nf.library.dao;

import edu.nf.library.entity.BookType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class BookTypeDaoTest {

    @Test
    public void addBookType() {
    }

    @Test
    public void listBookType() {
        ApplicationContext context=new ClassPathXmlApplicationContext("daolicationContext.xml");
        BookTypeDao dao= context.getBean("bookTypeDao",BookTypeDao.class);
        List<BookType> list= dao.listBookType("科技");
        for (BookType type : list) {
            System.out.println(type.getT_classify());
        }
    }
}