package com.illusivezoo.repository;

import com.illusivezoo.domain.Animal;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalRepository extends InMemoryRepository<Animal> {

    protected void updateIfExists(Animal original, Animal updated) {
        original.setName(updated.getName());
    }

    protected void feedAnimal(Animal animal){

    }
}
