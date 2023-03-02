package member;

import hello.core.AppConfig;
import hello.core.memeber.Grade;
import hello.core.memeber.Member;
import hello.core.memeber.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();

    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);



        //when

        //then

    }

}
