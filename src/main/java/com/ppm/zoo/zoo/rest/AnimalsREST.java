package com.ppm.zoo.zoo.rest;

import com.ppm.zoo.zoo.entitys.Animals;
import com.ppm.zoo.zoo.services.AnimalsDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("animals")
public class AnimalsREST {
    
    @Autowired
    private AnimalsDAO animalDao;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<Animals>> getAnimals(){
        List<Animals> animals = animalDao.findAll();
        return ResponseEntity.ok(animals);
    }
    
    @RequestMapping(value = "{animalId}")
    public ResponseEntity<Animals> getAnimalById(@PathVariable("animalId") Long animalId){
        Optional<Animals> animalOptional = animalDao.findById(animalId);
        if(animalOptional.isPresent()){
            return ResponseEntity.ok(animalOptional.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Animals> createAnimal(@RequestBody Animals animal){
        Date now = new Date();
        if(null == animal.getFechaCreacion()){
            animal.setFechaCreacion(now);
        }
        if(null == animal.getFechaModificacion()){
            animal.setFechaModificacion(now);
        }
        if(null == animal.getAcuatico()){
            animal.setAcuatico(false);
        }
        Animals newAnimal = animalDao.save(animal);
        return ResponseEntity.ok(newAnimal);
    }

    @DeleteMapping(value = "{animalId}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("animalId") Long animalId){
        animalDao.deleteById(animalId);
        return ResponseEntity.ok(null);
    }
    
    @PutMapping
    public ResponseEntity<Animals> updateAnimal(@RequestBody Animals animal){
        Optional<Animals> animalOptional = animalDao.findById(animal.getId());
        if(animalOptional.isPresent()){
            Animals updatedAnimal = animalOptional.get();
            updatedAnimal.setAcuatico(animal.getAcuatico());
            updatedAnimal.setCantidad(animal.getCantidad());
            updatedAnimal.setClasificacion(animal.getClasificacion());
            updatedAnimal.setEspecie(animal.getEspecie());
            updatedAnimal.setFechaModificacion(new Date());
            updatedAnimal.setGrupo(animal.getGrupo());
            updatedAnimal.setHabitat(animal.getHabitat());
            updatedAnimal.setNombreComun(animal.getNombreComun());
            animalDao.save(updatedAnimal);
            return ResponseEntity.ok(updatedAnimal);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PatchMapping
    public ResponseEntity<Animals> updateAnimalNombreComun(@RequestBody Animals animal){
        Optional<Animals> animalOptional = animalDao.findById(animal.getId());
        if(animalOptional.isPresent()){
            Animals updatedAnimal = animalOptional.get(); 
            updatedAnimal.setNombreComun(animal.getNombreComun());
            updatedAnimal.setFechaModificacion(new Date());
            animalDao.save(updatedAnimal);
            return ResponseEntity.ok(updatedAnimal);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
