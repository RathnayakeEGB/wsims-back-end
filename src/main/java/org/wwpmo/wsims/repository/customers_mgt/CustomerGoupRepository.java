package org.wwpmo.wsims.repository.customers_mgt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wwpmo.wsims.entities.CustomerGroup;

import java.util.List;
@Repository
public interface CustomerGoupRepository extends JpaRepository<CustomerGroup,Integer> {

    CustomerGroup findAllByCustomerGroupName(String groupName);
    List<CustomerGroup>findAllByIsActive(String  isActive);
    int countAllByIsActive(String active);
    boolean existsByCustomerGroupName(String name);

}
