package edu.nf.library.dao;

import edu.nf.library.entity.BookMessage;
import edu.nf.library.entity.BorrowBook;
import edu.nf.library.entity.UserMessage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BorrowBookDaoTest {

    @Test
    public void borrowBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BorrowBookDao dao = context.getBean("borrowBookDao", BorrowBookDao.class);
        List<BorrowBook> bookList = dao.borrowBook(1, 6);
        System.out.println(bookList.size());
        for (BorrowBook book : bookList) {
            for (UserMessage message : book.getUserMessages()) {
                for (BookMessage bookBook : book.getBooks()) {
                    System.out.println(message.getUserName());
                    System.out.println(bookBook.getBookName());
                }
            }

        }
    }

    @Test
    public void returnBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BorrowBookDao dao = context.getBean("borrowBookDao", BorrowBookDao.class);
        BorrowBook borrowBook = dao.returnBook(2, 10011);
        for (UserMessage userMessage : borrowBook.getUserMessages()) {
            System.out.println(userMessage.getUserName());
        }
    }

    @Test
    public void borrowBook1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BorrowBookDao dao = context.getBean("borrowBookDao", BorrowBookDao.class);
        List<BorrowBook> bookList = dao.borrowBook1(1, 2, "15603806595", 0);
        System.out.println(bookList.size());
    }

    @Test
    public void getBorrowBookIdMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BorrowBookDao dao = context.getBean("borrowBookDao", BorrowBookDao.class);
        BorrowBook borrowBook = dao.getBorrowBookIdMessage(4);
        System.out.println(borrowBook.getPredictData());
    }

    @Test
    public void listStatic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("daolicationContext.xml");
        BorrowBookDao dao = context.getBean("borrowBookDao", BorrowBookDao.class);
    }
}