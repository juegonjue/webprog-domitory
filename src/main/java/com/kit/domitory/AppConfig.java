package com.kit.domitory;

import com.kit.domitory.book.BookService;
import com.kit.domitory.book.BookServiceImpl;
import com.kit.domitory.fee.FeePolicy;
import com.kit.domitory.fee.NewFeePolicy;
import com.kit.domitory.fee.OldFeePolicy;
import com.kit.domitory.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    MemberService memberService() {
        return new MemberServiceImpl(memberStorage());  // 바로 리턴
    }

    @Bean
    BookService bookService() {
        //return new BookServiceImpl(new OldFeePolicy());
        return new BookServiceImpl(feePolicy());
    }

    @Bean
    MemberStorage memberStorage() {
        return new DBMemberStorage();
    }

    @Bean
    FeePolicy feePolicy() {
        return new NewFeePolicy();
    }
}
