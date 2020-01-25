package org.wwpmo.wsims.service;

import org.wwpmo.wsims.entities.Customer;
import org.wwpmo.wsims.models.ResponseObject;

import java.util.List;

public interface CustomerManagementService {

    List<Customer> getAllCustomers() throws Exception;

    Customer getCustomerByRegNo(String regNo)throws Exception;

    List<Customer> getAllCustomersByStatus()throws Exception;

    int getCustomerCount()throws Exception;

    ResponseObject createNewCustomer(Customer c)throws Exception;

    ResponseObject updateNewCustomer(Customer c)throws Exception;

    int customersCoutGetByStatus(String status)throws Exception;



}
