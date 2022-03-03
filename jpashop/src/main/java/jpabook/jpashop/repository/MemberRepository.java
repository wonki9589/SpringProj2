package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  // @PersistenceContext
  // private EntityManager em;
    // 엔티티메니저 사용
    //영속성 컨텍스트에 멤버엔티티 넣고
    //트랜잭션 커밋 시점 디비에 반영
  private final EntityManager em;





    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
     return em.find(Member.class, id);

    }

    public  List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
    // jpql 사용 , 반환타입
    // inline Variable commend --> option + commend + n

    public List<Member> findByName(String name){
       return em.createQuery("select m from Member m where m.name= :name", Member.class)
               .setParameter("name",name).getResultList();
    }
}
