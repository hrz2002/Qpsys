package business.service;

import java.util.*;

import business.entity.*;



import framework.jpa.*;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findByEntityId(EntityId id);

    public Customer save(Customer me);

    public Customer update(Customer me);

    public void remove(EntityId entityId);

}
