package com.illusivezoo.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.illusivezoo.domain.Animal;
import org.springframework.hateoas.ResourceSupport;

public class AnimalResource extends ResourceSupport {

    private final long id;
    private final String name;
    private final String species;

    public AnimalResource(Animal animal) {
        id = animal.getId();
        name = animal.getName();
        species = animal.getSpecies();

    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}
