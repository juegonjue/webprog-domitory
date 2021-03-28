package com.kit.domitory.ComponentScan;

import com.kit.domitory.ComAppConfig;
import com.kit.domitory.member.MemberService;
import com.kit.domitory.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComponentScanTest {
    @Test
    void comScanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext((ComAppConfig.class));
        //MemberService memberService = ac.getBean(MemberService.class); //class로 조회
        Object memberService = ac.getBean("memberServiceImpl"); //이름으로 조회 (클래스 이름의 첫문자를 소문자로 바꾼게 빈 이름)
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
