package com.illusivezoo.controller;

import com.illusivezoo.App;
import com.illusivezoo.domain.Animal;
import com.illusivezoo.repository.AnimalRepository;
import com.illusivezoo.resource.AnimalResource;
import com.illusivezoo.resource.AnimalResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Animal.class)
@RequestMapping(value = "/zoo", produces = "application/json")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private AnimalResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<AnimalResource>> findAllAnimals() {
        List<Animal> animals = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(animals), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AnimalResource> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = repository.create(animal);
        return new ResponseEntity<>(assembler.toResource(createdAnimal), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnimalResource> findAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = repository.findById(id);

        if (animal.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(animal.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<AnimalResource> updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        boolean wasUpdated = repository.update(id, updatedAnimal);

        if (wasUpdated) {
            return findAnimalById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}/Feed",method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<AnimalResource> feedAnimal(@PathVariable Long id) {
        Optional<Animal> optAnimal = repository.findById(id);

        if (optAnimal.isPresent()) {
            Animal animal = optAnimal.get();
            animal.setLastMealTime(LocalDateTime.now());

            boolean wasUpdated = repository.update(id, animal);
            if (wasUpdated) {
                return findAnimalById(id);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}/Clean",method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<AnimalResource> cleanAnimal(@PathVariable Long id) {
        Optional<Animal> optAnimal = repository.findById(id);

        if (optAnimal.isPresent()) {
            Animal animal = optAnimal.get();
            animal.setLastCleaningTime(LocalDateTime.now());

            boolean wasUpdated = repository.update(id, animal);
            if (wasUpdated) {
                return findAnimalById(id);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}?Sleep={isSleep}",method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<AnimalResource> changeAnimalSleepState(@PathVariable Long id, @PathVariable boolean isSleep) {
        Optional<Animal> optAnimal = repository.findById(id);

        if (optAnimal.isPresent()) {
            Animal animal = optAnimal.get();
            if(isSleep)
                animal.setIsSleep(true);
            else
                animal.setIsSleep(false);

            boolean wasUpdated = repository.update(id, animal);
            if (wasUpdated) {
                return findAnimalById(id);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
