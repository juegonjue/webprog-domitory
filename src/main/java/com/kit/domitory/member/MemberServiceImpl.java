package com.kit.domitory.member;

//임플받는 구현체가 하나일 경우에는 관례상 Impl붙여준다

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // component로 설정해줘야, componentScan으로 scan된다. 그리고 autowired로 걸린걸 가지고간다.
//@RequiredArgsConstructor    //final이 붙은 필드를 가지고 constructor를 만들어준다
public class MemberServiceImpl implements MemberService {

    private final MemberStorage memberStorage ;  // 아직 뭘로 받아올지 모르겠어서, file로 받아온다치면 FileMemberStorage

    // 수정자 (setter), 좋은방법은 아님
//    @Autowired
//    public void setMemberStorage(MemberStorage memberStorage) {
//        System.out.println("memberStorage = " + memberStorage);
//        this.memberStorage = memberStorage;
//    }


    // memberStorage를만들 때 초기화가 되지 않앗으니 이 생성자로 초기화해준다. --> lombok쓰면서 필요없어짐
    //@Autowired
//    public MemberServiceImpl(@Qualifier("mainMemberStorage") MemberStorage memberStorage) {
//        this.memberStorage = memberStorage;
//    }
    public MemberServiceImpl(MemberStorage memberStorage) {
        //System.out.println("selectedMembewrStorage = " + memberStorage);
        this.memberStorage = memberStorage;
    }

    @Override
    public void register(Member member) {
        memberStorage.store(member);
    }

    @Override
    public Member findMember(Member member) {
        return memberStorage.findById(member.getId());
    }

}
