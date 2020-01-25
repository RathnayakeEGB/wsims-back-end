package org.wwpmo.wsims.repository.customers_mgt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wwpmo.wsims.entities.Customer;

import java.util.List;

@Repository
public interface CutomerRepository extends JpaRepository<Customer ,Integer> {

    Customer findByCustomerReqNo(String regNo);
    List<Customer> findAllByStatus(String status);
    int countAllByCustomerReqNo(String reqNo);
    int  countAllByStatus(String status);
    int countAllByGroupId_CustomerGroupName(String name);
    
}

