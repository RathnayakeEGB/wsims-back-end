package org.wwpmo.wsims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wwpmo.wsims.entities.Role;
import org.wwpmo.wsims.models.login.ERole;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}