package com.kit.domitory;

import com.kit.domitory.member.Member;
import com.kit.domitory.member.MemberService;
import com.kit.domitory.member.MemberServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //MemberService memberService = appConfig.memberService();
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //BookService bookService = ac.getBean("bookService", BookService.class);

        Member member = new Member(1L, "kim", 1);
        memberService.register(member);
        Member findMember = memberService.findMember(member);

        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
