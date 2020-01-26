package org.wwpmo.wsims.service.customer_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.wwpmo.wsims.entities.CustomerGroup;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.repository.customers_mgt.CustomerGoupRepository;
import org.wwpmo.wsims.service.CustomerGroupManagementService;
import org.wwpmo.wsims.service.UniqueNumberService;
import org.wwpmo.wsims.utils.SEARCH_IDS;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CustomerGroupManagementServiceImpl implements CustomerGroupManagementService {

    private static final Logger log = LoggerFactory.getLogger(CustomerGroupManagementServiceImpl.class);

    @Autowired
    private CustomerGoupRepository goupRepository;

    @Autowired
    private UniqueNumberService uniqueNumberService;

    public List<CustomerGroup>getAllCustomerGroupStaus(String statu) throws Exception{
        log.debug("[_____Get All Customer Group By Status....");
      return   goupRepository.findAllByIsActive(statu);
    }

    public List<CustomerGroup>getAllCustomerGroup() throws Exception{
        log.debug("[_____Get All Customer Groups....");
        return goupRepository.findAll();
    }

    public ResponseObject createdNewCustomerGroup(CustomerGroup group) throws Exception{
        log.debug("[_____Create New Customer Group....");

        if(group.getIsActive().isEmpty()){
            log.debug("[_____Property IsActive Is Too Large..");
            return new ResponseObject(400,"Status Is Empty");
        }

        if(group.getIsActive().length()>1){
            log.debug("[_____Property IsActive Is Too Large..");
            return new ResponseObject(400,"Status Too Long...");
        }

        if(group.getCustomerGroupName().isEmpty()){
            log.debug("[_____Property Group Name Is Empty..");
            return  new ResponseObject(400,"Gropu Name Too Large");
        }

        if(group.getCustomerGroupName().length()>30){
            log.debug("[_____Property Group Name Is Too Large..");
            return  new ResponseObject(400,"Gropu Name Too Large");

        }

        if(!group.getDescription().isEmpty()) {
            if (group.getDescription().length() > 100) {
                log.debug("[_____Property IsActive Is Too Large..");
                return new ResponseObject(400, "Description Is Too Long...");
            }
        }
        group.setCreatedDate(LocalDateTime.now());
        goupRepository.save(group);
        uniqueNumberService.getUpdateNext(SEARCH_IDS.CUSTOMERGROUP.getValue());
        return new ResponseObject(200,"OK");
    }


    public boolean isGroupNameUsed(String name)throws Exception{
        log.debug("find Out Group Name Already Used Or Not...");
        return goupRepository.existsByCustomerGroupName(name);
    }

    @Override
    public ResponseObject updateCustomerGroup(@RequestBody CustomerGroup group) throws Exception {
        log.debug("[_____Update Customer Group....");

        System.out.println("XXX" +group);

        if(group.getIsActive().isEmpty()){
            log.debug("[_____Property IsActive Is Too Large..");
            return new ResponseObject(400,"Status Is Empty");
        }

        if(group.getIsActive().length()>1){
            log.debug("[_____Property IsActive Is Too Large..");
            return new ResponseObject(400,"Status Too Long...");
        }

        if(group.getCustomerGroupName().isEmpty()){
            log.debug("[_____Property Group Name Is Empty..");
            return  new ResponseObject(400,"Gropu Name Too Large");
        }

        if(group.getCustomerGroupName().length()>30){
            log.debug("[_____Property Group Name Is Too Large..");
            return  new ResponseObject(400,"Gropu Name Too Large");

        }

        if(!group.getDescription().isEmpty()) {
            if (group.getDescription().length() > 100) {
                log.debug("[_____Property IsActive Is Too Large..");
                return new ResponseObject(400, "Description Is Too Long...");
            }
        }

        CustomerGroup g = goupRepository.findAllByCustomerGroupName(group.getCustomerGroupName());
        g.setUpdatedBy(group.getCreatedBy());
        g.setUpdatedDate(LocalDateTime.now());
        g.setDescription(group.getDescription());
        g.setIsActive(group.getIsActive());
        g.setCustomerGroupName(group.getCustomerGroupName());

        return new ResponseObject(200,"OK");


    }

}
