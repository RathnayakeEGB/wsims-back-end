package org.wwpmo.wsims.service.customer_service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wwpmo.wsims.entities.Customer;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.service.CustomerManagementService;

import java.util.List;

@Service
@Transactional
public class CustomerManagementServiceImpl implements CustomerManagementService {
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
        return null;
    }

    @Override
    public ResponseObject updateNewCustomer(Customer c) throws Exception {
        return null;
    }

    @Override
    public int customersCoutGetByStatus(String status) throws Exception {
        return 0;
    }
}
