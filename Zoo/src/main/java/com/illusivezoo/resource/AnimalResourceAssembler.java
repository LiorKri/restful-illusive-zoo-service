package com.illusivezoo.resource;

import com.illusivezoo.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class AnimalResourceAssembler extends ResourceAssembler<Animal, AnimalResource> {

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public AnimalResource toResource(Animal animal) {

        AnimalResource resource = new AnimalResource(animal);

        final Link selfLink = entityLinks.linkToSingleResource(animal);

        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));

        return resource;
    }
}
