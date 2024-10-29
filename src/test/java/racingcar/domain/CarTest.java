package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void getName() {
        String carName = "pobi";

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void getDistance() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @RepeatedTest(2)
    void move() {
        car.move();
        assertThat(car.getDistance()).isEqualTo(car.getDistance());
    }
}