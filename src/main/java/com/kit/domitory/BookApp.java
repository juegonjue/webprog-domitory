package com.kit.domitory;

import com.kit.domitory.book.Book;
import com.kit.domitory.book.BookService;
import com.kit.domitory.book.BookServiceImpl;
import com.kit.domitory.book.DormName;
import com.kit.domitory.member.Member;
import com.kit.domitory.member.MemberService;
import com.kit.domitory.member.MemberServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApp {
  public static void main(String[] args) {

//      AppConfig appConfig = new AppConfig();
//      MemberService memberService = new MemberServiceImpl();
//      BookService bookService = new BookServiceImpl();

//      MemberService memberService = appConfig.memberService();
//      BookService bookService = appConfig.bookService();
      AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
      MemberService memberService = ac.getBean("memberService", MemberService.class);
      BookService bookService = ac.getBean("bookService", BookService.class);

      Long memberId = 1L;
      Member member = new Member(memberId, "kim", 1);
      memberService.register(member);
      Member findMember = memberService.findMember(member);

      Book book = bookService.assignRoom(findMember, DormName.PUREUM, "101");
    System.out.println("book = " + book);
  }
}
