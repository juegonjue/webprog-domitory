package com.kit.domitory.member;

//임플받는 구현체가 하나일 경우에는 관례상 Impl붙여준다
public class MemberServiceImpl implements MemberService{

    private final MemberStorage memberStorage ;  // 아직 뭘로 받아올지 모르겠어서, file로 받아온다치면 FileMemberStorage

    // memberStorage를만들 때 초기화가 되지 않앗으니 이 생성자로 초기화해준다.
    public MemberServiceImpl(MemberStorage memberStorage) {
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
