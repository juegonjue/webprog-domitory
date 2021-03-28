package com.kit.domitory.book;

import com.kit.domitory.member.Member;


public interface BookService {
    Book assignRoom(Member member, DormName dormName, String roomNumber);
}
