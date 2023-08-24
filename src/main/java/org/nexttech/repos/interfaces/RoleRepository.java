package org.nexttech.repos.interfaces;

import java.util.Optional;

import org.nexttech.ERole;
import org.nexttech.repos.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}