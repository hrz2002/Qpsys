package business.service;

import java.util.*;

import javax.persistence.*;
import org.springframework.transaction.annotation.*;

import business.entity.Member;
import framework.jpa.*;

@Transactional
public class MemberServiceImpl implements MemberService{

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * <p>
     * プロパティ<code>entityManager</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>entityManager</code>の値
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<Member> findAll() {
        final Query query = getEntityManager().createQuery("select p FROM Member p order by p.entityId");
//        query.setFirstResult(0);
//        query.setMaxResults(3);
        return query.getResultList();
    }

    public Member findByEntityId(EntityId entityId) {
       // final Query query = getEntityManager().createQuery("select p FROM Member p where p.entityId = :theEntityId ");
//      query.setFirstResult(0);
//      query.setMaxResults(3);
        //query.setParameter("theEntityId", id.toLong());
        EntityManager entityManager = getEntityManager() ;
        Member member = entityManager.find(Member.class, entityId.toLong());
        return member;
//      return (Member) query.getSingleResult();
    }

    public void  remove(final EntityId entityId) {
        EntityManager entityManager = getEntityManager() ;
        Member me = entityManager.find(Member.class, entityId.toLong());
        entityManager.remove(me);
    }

    public Member save(final Member member) {
        Member ret = null;
        if(member.getEntityId() != null){
           ret = getEntityManager().merge(member);
        } else {
            getEntityManager().persist(member);
//            for(ProjectInfo p :member.getProjectInfos()){
//                getEntityManager().persist(p);
//            }
        }
        return ret;
    }

    public Member update(final Member member) {
        return getEntityManager().merge(member);
    }

}
