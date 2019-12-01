package com.illusivezoo.test.util;

import com.illusivezoo.domain.Animal;
import org.junit.Assert;

import java.time.LocalDateTime;

public class AnimalTestUtils {

    /**
     * Method assert that all properties of 2 given animals are identical except from the ids
     * @param expected
     * @param actual
     */
    public static void assertAllButIdsMatchBetweenAnimals(Animal expected, Animal actual) {
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getSpecies(), actual.getSpecies());
        Assert.assertEquals(expected.getLastMealTime(), actual.getLastMealTime());
        Assert.assertEquals(expected.getLastCleaningTime(), actual.getLastCleaningTime());
        Assert.assertEquals(expected.getIsSleep(), actual.getIsSleep());
    }

    /**
     * Method generate animal for test
     * @return
     */
    public static Animal generateTestAnimal() {
        Animal animal = new Animal();
        animal.setName("Boni");
        animal.setSpecies("Dog");
        animal.setLastMealTime(LocalDateTime.now());
        animal.setLastCleaningTime(LocalDateTime.now());
        animal.setIsSleep(false);
        return animal;
    }
}
