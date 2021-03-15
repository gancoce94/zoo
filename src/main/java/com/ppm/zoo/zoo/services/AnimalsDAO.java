package com.ppm.zoo.zoo.services;

import com.ppm.zoo.zoo.entitys.Animals;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalsDAO  extends JpaRepository <Animals, Long>{
    
}
