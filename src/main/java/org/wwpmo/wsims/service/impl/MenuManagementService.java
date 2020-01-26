package org.wwpmo.wsims.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wwpmo.wsims.entities.menu.Menu3;
import org.wwpmo.wsims.entities.menu.Menu2;
import org.wwpmo.wsims.entities.menu.Menu;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.repository.Menu3Repository;
import org.wwpmo.wsims.repository.Menu2Repositrory;
import org.wwpmo.wsims.repository.MenuRepository;

import java.util.List;

@Service
@Transactional
public class MenuManagementService {

    private static final Logger log = LoggerFactory.getLogger(MenuManagementService.class);


    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private Menu2Repositrory menu2Repositrory;

    @Autowired
    private Menu3Repository menu3Repository;

    public ResponseObject createNewMenuItems(Menu3 m) throws  Exception{

        log.debug("Creating new Menue Itme Menue Level #3 Menu Level");

        if(m.getTitle()==null){
            throw new RuntimeException("INVALID REQUEST NO URL TITLE...... DEVELOPER CREATE EXCEPTION");
        }

        if(m!=null){

            if(m.getLevel()==1){
                Menu m1 = new Menu();
                m1.setLevel(m.getLevel());
                m1.setDisabled(m.isDisabled());
                m1.setIcon(m.getIcon());
                m1.setIsActive(m.getIsActive());
                m1.setOpen(m.isOpen());
                m1.setTitle(m.getTitle());
                m1.setSelected(m.isSelected());
                m1.setRouterLink(m.getRouterLink());
                m1.setIconLocation(m.getIconLocation());
                menuRepository.save(m1);

                // level 2 Menu
            }else if(m.getLevel()==3){
                Menu3 m2 = new Menu3();
                m2.setLevel(m.getLevel());
                m2.setDisabled(m.isDisabled());
                m2.setIcon(m.getIcon());
                m2.setIsActive(m.getIsActive());
                m2.setOpen(m.isOpen());
                m2.setTitle(m.getTitle());
                m2.setSelected(m.isSelected());
                m2.setRouterLink(m.getRouterLink());
                m2.setIconLocation(m.getIconLocation());
                m2.setParentId(menu2Repositrory.findByTitle(m.getTitle()));
                menu3Repository.save(m2);

            }else if(m.getLevel()==2){
                Menu2 m3 = new Menu2();
                m3.setLevel(m.getLevel());
                m3.setDisabled(m.isDisabled());
                m3.setIcon(m.getIcon());
                m3.setIsActive(m.getIsActive());
                m3.setOpen(m.isOpen());
                m3.setTitle(m.getTitle());
                m3.setSelected(m.isSelected());
                m3.setRouterLink(m.getRouterLink());
                m3.setIconLocation(m.getIconLocation());
                m3.setParentId(menuRepository.findByTitle(m.getTitle()));
                menu2Repositrory.save(m3);
            }


        }
        return new ResponseObject(200,"OK");
    }

    public List<Menu> getAllmenuItems() throws  Exception{
       return menuRepository.findAll();
    }
}
