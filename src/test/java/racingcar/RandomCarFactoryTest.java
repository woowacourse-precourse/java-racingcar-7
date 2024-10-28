package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomCarFactoryTest {

    @Test
    void create() {
        // given
        RandomCarFactory randomCarFactory = new RandomCarFactory();

        // when
        Car car = randomCarFactory.create("pobi");

        // then
        assertEquals("pobi", car.getName());
    }
}