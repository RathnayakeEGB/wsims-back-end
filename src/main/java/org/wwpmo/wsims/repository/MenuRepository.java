package org.wwpmo.wsims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wwpmo.wsims.entities.menu.Menu;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

   Menu findByTitle(String title);
}
