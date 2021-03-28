package com.kit.domitory.member;

public interface MemberService {
    void register(Member member);       // 생활관에 등록된 학생인지 확인
    Member findMember(Member member);   //id만 가져오면되긴하는데 서비스할때 한번에 가져오면 활용범위가 넓어지니 한번에 가지고온다
}
