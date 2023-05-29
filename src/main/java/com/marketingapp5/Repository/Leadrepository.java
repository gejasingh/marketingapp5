package com.marketingapp5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp5.entities.Lead;

public interface Leadrepository extends JpaRepository<Lead,Long> {

}
