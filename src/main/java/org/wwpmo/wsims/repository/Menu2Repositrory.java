package org.wwpmo.wsims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wwpmo.wsims.entities.menu.Menu2;
import org.wwpmo.wsims.entities.menu.Menu3;

public interface Menu2Repositrory extends JpaRepository<Menu2,Integer> {

    Menu2 findByTitle(String t);

}
