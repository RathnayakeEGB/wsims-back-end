package org.wwpmo.wsims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wwpmo.wsims.WaterSupplyInformationManagementSystemApplication;
import org.wwpmo.wsims.entities.CustomerGroup;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.service.CustomerGroupManagementService;

@RestController
@CrossOrigin
@RequestMapping(value = "/cus_group_mgt")
public class CustomerGroupsController {

    private static final Logger log = LoggerFactory.getLogger(CustomerGroupsController.class);


    @Autowired
    private CustomerGroupManagementService managementService;

    @PostMapping( value = "/createNewCustomerGroup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewCustomerGroup(@RequestBody CustomerGroup group){
        try {
            if(managementService.isGroupNameUsed(group.getCustomerGroupName())){
                log.debug("[______GroupName Already Used !");
                return new ResponseEntity<>( new ResponseObject(400,"Customer Group Name Already Used......"), HttpStatus.OK);
            }
            ResponseObject ro = managementService.createdNewCustomerGroup(group);
            return new ResponseEntity<>(ro,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            ResponseObject ro = new ResponseObject(500, "Internal Server Error !");
            return new ResponseEntity<>(ro,HttpStatus.OK);
        }
    }

}
