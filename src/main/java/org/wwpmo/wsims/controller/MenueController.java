package org.wwpmo.wsims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wwpmo.wsims.entities.menu.Menu3;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.service.MenuManagementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/menu")
public class MenueController {

    @Autowired
    private MenuManagementService menuManagementService;

    @GetMapping(value = "/getAllMenuItems",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMenuItems(){

        try {
            return new ResponseEntity<>(menuManagementService.getAllmenuItems(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/createMenuItems")
    public ResponseEntity<?> createMenueItems(@RequestBody Menu3 u){

        try {
            System.out.println("Calling............."+u);
            ResponseObject items = menuManagementService.createNewMenuItems(u);
            return new ResponseEntity<>( items,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
