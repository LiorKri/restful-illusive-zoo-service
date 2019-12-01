package com.illusivezoo.test.unit.repository;

import com.illusivezoo.domain.Animal;
import com.illusivezoo.repository.AnimalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.illusivezoo.test.util.AnimalTestUtils.assertAllButIdsMatchBetweenAnimals;
import static com.illusivezoo.test.util.AnimalTestUtils.generateTestAnimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalRepositoryTest {

    private static final long NONEXISTENT_ID = 1000;

    @Autowired
    private AnimalRepository repository;

    @Before
    public void setUp() {
        repository.clear();
    }

    /**
     * Test find nonexistent animal in order to ensure that optional is not present
     * @throws Exception
     */
    @Test
    public void testFindNonexistentAnimal() throws Exception {
        assertNoExistingAnimals();
        Optional<Animal> animal = repository.findById(NONEXISTENT_ID);
        Assert.assertFalse(animal.isPresent());
    }

    private void assertNoExistingAnimals() {
        assertExistingAnimalCount(0);
    }

    private void assertExistingAnimalCount(int count) {
        Assert.assertEquals(count, repository.getCount());
    }

    /**
     * Test find existing animal in order to ensure that optional is present
     * @throws Exception
     */
    @Test
    public void testFindExistingAnimal() throws Exception {
        Animal injectedAnimal = injectAnimal();
        Optional<Animal> foundAnimal = repository.findById(injectedAnimal.getId());
        Assert.assertTrue(foundAnimal.isPresent());
    }

    private Animal injectAnimal() {
        Animal createdAnimal = repository.create(generateTestAnimal());
        return createdAnimal;
    }

    /**
     * Test find existing animal to ensure correct animal values
     * @throws Exception
     */
    @Test
    public void testFindExistingAnimalToEnsureCorrectAnimalValues() throws Exception {
        Animal injectedAnimal = injectAnimal();
        Optional<Animal> foundAnimal = repository.findById(injectedAnimal.getId());
        assertAnimalsMatch(injectedAnimal, foundAnimal.get());
    }

    private static void assertAnimalsMatch(Animal expected, Animal actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        assertAllButIdsMatchBetweenAnimals(expected, actual);
    }

    /**
     * Test find all when no existing animals in order to ensure no animals found
     * @throws Exception
     */
    @Test
    public void testFindAllWithNoExistingAnimals() throws Exception {
        assertFindAllIsCorrectWithAnimalsCount(0);
    }

    private void assertFindAllIsCorrectWithAnimalsCount(int count) {
        injectGivenNumberOfAnimals(count);
        assertExistingAnimalCount(count);
        List<Animal> animalsFound = repository.findAll();
        Assert.assertEquals(count, animalsFound.size());
    }

    private List<Animal> injectGivenNumberOfAnimals(int count) {
        List<Animal> injectedAnimals = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            injectedAnimals.add(injectAnimal());
        }

        return injectedAnimals;
    }
}
