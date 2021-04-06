package com.kit.domitory.AopTest;

import com.kit.domitory.ComAppConfig;
import com.kit.domitory.member.Member;
import com.kit.domitory.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(ComAppConfig.class);

    @Test
    void AOP_테스트() {
        MemberService memberService = ac.getBean(MemberService.class);
        Member memberA = new Member(1L, "kim", 1);
        memberService.register(memberA);
    }

}
