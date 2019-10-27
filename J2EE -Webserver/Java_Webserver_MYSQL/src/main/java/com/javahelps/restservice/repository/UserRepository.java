package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javahelps.restservice.entity.GetAllData;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<GetAllData, String> {

}