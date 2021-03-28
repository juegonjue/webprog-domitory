package com.kit.domitory.member;

public interface MemberStorage {
    void store (Member member);         //관원 저장
    Member findById(Long memberId);     //관원 조회
}
