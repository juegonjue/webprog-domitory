package com.kit.domitory.fee;

import com.kit.domitory.book.DormName;
import com.kit.domitory.book.DormName;
import com.kit.domitory.member.Member;

// fee()메서드를 정의, 요청한 생활관의 요금을
// 비즈니스로직으로 산정해서 최종반환하는 메소드
public interface FeePolicy {
    int fee(Member member, DormName dormName);
}
