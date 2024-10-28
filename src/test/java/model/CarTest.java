package model;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {


    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @Test
    void carInitializationTest() {

        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.isStopped()).isTrue();
    }

    @Test
    void carMoveTest() {

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.isStopped()).isFalse();
    }

    @Test
    void carStopTest() {

        car.move();
        car.stop();

        assertThat(car.isStopped()).isTrue();
    }

    @Test
    void carMultipleMovesTest() {
        car.move();
        car.move();
        car.move();

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void carToStringTest() {

        assertThat(car.toString()).isEqualTo("car1");
    }
}

