package org.wwpmo.wsims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wwpmo.wsims.entities.menu.Menu2;
import org.wwpmo.wsims.entities.menu.Menu3;

@Repository
public interface Menu3Repository extends JpaRepository<Menu3,Integer> {
    Menu3 findByTitle(String t) ;
}
