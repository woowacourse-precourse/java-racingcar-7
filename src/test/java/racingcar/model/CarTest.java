package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    public void setUp(){
        car = new Car("test");
    }

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    void moveForward() {
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}