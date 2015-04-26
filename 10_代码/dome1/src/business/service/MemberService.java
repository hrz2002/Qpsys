package business.service;

import java.util.*;

import business.entity.Member;



import framework.jpa.*;

public interface MemberService {

    public List<Member> findAll();

    public Member findByEntityId(EntityId id);

    public Member save(Member me);

    public Member update(Member me);

    public void remove(EntityId entityId);

}
