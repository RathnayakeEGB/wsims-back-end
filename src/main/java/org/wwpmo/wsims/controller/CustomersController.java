package org.wwpmo.wsims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wwpmo.wsims.WaterSupplyInformationManagementSystemApplication;
import org.wwpmo.wsims.entities.Customer;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.service.CustomerManagementService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_mgt")
public class CustomersController {

    private static final Logger log = LoggerFactory.getLogger(CustomersController.class);


    @Autowired
    private CustomerManagementService customerManagementService;

    @GetMapping(value = "/getAllCustomers",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getAllCustomers(){
        try {
            log.debug("GetAll...Customers.....");
            List<Customer> list = customerManagementService.getAllCustomers();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
    }

    @PostMapping(value = "/createNewCustomerAccount",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewCustomer(@RequestBody Customer c){

        log.debug("Create Customer log.."+c.getCustomerReqNo());

        try {

            if(customerManagementService.isCustomerExist(c.getCustomerReqNo())){
                return new ResponseEntity<>(new ResponseObject(400,"REGISTER NUMBER ALREADY USED !"),HttpStatus.OK);
            }

            if(customerManagementService.isEmailUsed(c.getEmail())){
                return new ResponseEntity<>(new ResponseObject(400,"Email ALREADY USED !"),HttpStatus.OK);
            }

            ResponseObject ro = customerManagementService.createNewCustomer(c);
            return  new ResponseEntity<>(ro,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResponseEntity<>(new ResponseObject(500,"Internal Server Error"),HttpStatus.OK);
        }
    }

}
