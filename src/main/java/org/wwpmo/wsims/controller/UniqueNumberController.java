package org.wwpmo.wsims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.service.UniqueNumberService;

@RestController
@CrossOrigin
@RequestMapping(value = "/numbers")
public class UniqueNumberController {

    private static final Logger log = LoggerFactory.getLogger(UniqueNumberController.class);


    @Autowired
    private UniqueNumberService uniqueNumberService;

    @GetMapping(value = "/getNumberById/{srarchId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNewNumbers(@PathVariable("srarchId") int srarchId){
        try {
            log.debug("[____Calling New Number....");
            String number = uniqueNumberService.getNextUniqueNumber(srarchId);
            return  new ResponseEntity<>(new ResponseObject(200,number), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

}
