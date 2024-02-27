package com.postApi.apiforPost.repository;

import com.postApi.apiforPost.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional <Role> findByName(String name);
}
