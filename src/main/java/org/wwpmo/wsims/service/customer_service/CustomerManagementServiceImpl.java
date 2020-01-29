package org.wwpmo.wsims.service.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wwpmo.wsims.entities.Customer;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.repository.customers_mgt.CustomerGoupRepository;
import org.wwpmo.wsims.repository.customers_mgt.CustomerRepository;
import org.wwpmo.wsims.service.CustomerManagementService;

import java.util.List;

@Service
@Transactional
public class CustomerManagementServiceImpl implements CustomerManagementService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return null;
    }

    @Override
    public Customer getCustomerByRegNo(String regNo) throws Exception {
        return null;
    }

    @Override
    public List<Customer> getAllCustomersByStatus() throws Exception {
        return null;
    }

    @Override
    public int getCustomerCount() throws Exception {
        return 0;
    }

    @Override
    public ResponseObject createNewCustomer(Customer c) throws Exception {

        System.out.println("XXX-->>"+c);
        customerRepository.save(c);
        return new ResponseObject(200,"OK");
    }

    @Override
    public ResponseObject updateNewCustomer(Customer c) throws Exception {
        return null;
    }

    @Override
    public int customersCoutGetByStatus(String status) throws Exception {
        return 0;
    }

    @Override
    public boolean isCustomerExist(String regNo) throws Exception {
        return customerRepository.existsByCustomerReqNo(regNo);
    }

    @Override
    public boolean isEmailUsed(String email) throws Exception {
        return customerRepository.existsByEmail(email);
    }


}
