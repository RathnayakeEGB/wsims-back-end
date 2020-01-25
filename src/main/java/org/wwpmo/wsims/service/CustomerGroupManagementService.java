package org.wwpmo.wsims.service;

import org.wwpmo.wsims.entities.CustomerGroup;
import org.wwpmo.wsims.models.ResponseObject;

import java.util.List;

public interface CustomerGroupManagementService {

    public List<CustomerGroup> getAllCustomerGroupStaus(String statu) throws Exception;

    public List<CustomerGroup>getAllCustomerGroup() throws Exception;

    public ResponseObject createdNewCustomerGroup(CustomerGroup group) throws Exception;

    public boolean isGroupNameUsed(String name)throws Exception;

    public ResponseObject updateCustomerGroup(CustomerGroup group) throws Exception;


}
