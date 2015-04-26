package business.service;

import java.util.*;

import javax.persistence.*;
import org.springframework.transaction.annotation.*;

import business.entity.*;
import framework.jpa.*;

@Transactional
public class CustomerServiceImpl implements CustomerService{

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
    public List<Customer> findAll() {
        final Query query = getEntityManager().createQuery("select p FROM Customer p order by p.entityId");
//        query.setFirstResult(0);
//        query.setMaxResults(3);
        return query.getResultList();
    }

    public Customer findByEntityId(EntityId entityId) {
       // final Query query = getEntityManager().createQuery("select p FROM Customer p where p.entityId = :theEntityId ");
//      query.setFirstResult(0);
//      query.setMaxResults(3);
        //query.setParameter("theEntityId", id.toLong());
        EntityManager entityManager = getEntityManager() ;
        Customer customer = entityManager.find(Customer.class, entityId.toLong());
        return customer;
//      return (Customer) query.getSingleResult();
    }

    public void  remove(final EntityId entityId) {
        EntityManager entityManager = getEntityManager() ;
        Customer me = entityManager.find(Customer.class, entityId.toLong());
        entityManager.remove(me);
    }

    public Customer save(final Customer customer) {
        Customer ret = null;
        if(customer.getEntityId() != null){
           ret = getEntityManager().merge(customer);
        } else {
            getEntityManager().persist(customer);
        }
        return ret;
    }

    public Customer update(final Customer customer) {
        return getEntityManager().merge(customer);
    }

}
