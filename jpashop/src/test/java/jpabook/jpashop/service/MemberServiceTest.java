package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
// 두개 어노테이션이 있어야 실제로 스프링부트 테스트 가능
@Transactional
// 롤백하는 기능
public class MemberServiceTest {


    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
   // @Rollback(false)
    // false 하면 롤백을 안해서 db에 저장됨
    public void 회원가입() throws  Exception {

        //Given
        Member member = new Member();
        member.setName("abc");

        //When
        Long saveId = memberService.join(member);

        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 =  new Member();
        member1.setName("mo");

        Member member2 =  new Member();
        member2.setName("mo");
        //when
        memberService.join(member1);
        memberService.join(member2); // 예외발생해야함
        //then
        fail("예외가 발생해야 한다.");
    }


}