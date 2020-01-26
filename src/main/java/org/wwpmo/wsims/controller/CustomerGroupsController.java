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

import java.util.List;

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

    @GetMapping(value = "/getAllCustomerGroups",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCustomerGroups(){

        log.debug("[___________Get All Customer Groups.....");
        try {
            List<CustomerGroup> list = managementService.getAllCustomerGroup();
            return  new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return null;
        }
    }

    @PutMapping(value = "/updateCustomerGroupInfo",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateCustomerGroupInfo(@RequestBody CustomerGroup group){
        log.debug("[____Update Information...............");
        try {
            ResponseObject rs = managementService.updateCustomerGroup(group);
            return new ResponseEntity<>(rs,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseObject(500,"Error"),HttpStatus.OK);
        }
    }
}
