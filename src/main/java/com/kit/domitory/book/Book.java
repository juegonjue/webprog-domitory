package com.kit.domitory.book;

import com.kit.domitory.member.Member;

// 예약정보를 담고있다
public class Book {
    private Member member;
    private DormName dormName;
    private int fee;

    public Book(Member member, DormName dormName, int fee) {
        this.member = member;
        this.dormName = dormName;
        this.fee = fee;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public DormName getDormName() {
        return dormName;
    }

    public void setDormName(DormName dormName) {
        this.dormName = dormName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Book{" +
                "member=" + member +
                ", dormName=" + dormName +
                ", fee=" + fee +
                '}';
    }
}
