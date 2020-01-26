package org.wwpmo.wsims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.wwpmo.wsims.entities.UniqueNumber;

public interface UniqueNumberRepository extends JpaRepository<UniqueNumber,Integer> {

    UniqueNumber findBySearchId(int x);

    @Modifying
    @Query(value = "UPDATE UniqueNumber u SET u.nextNumber=u.nextNumber+1 WHERE u.searchId =:searchId")
    int updateNextIndex(@Param("searchId") int searchId);

}
