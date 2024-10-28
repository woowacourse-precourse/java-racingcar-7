package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        Car car = new Car("pobi");
        int beforeMove = car.getForward();

        car.move();

        Assertions.assertThat(car.getForward()).isEqualTo(beforeMove + 1);
    }

    @Test
    void print() {
        Car car = new Car("pobi");
        car.move();

        String print = car.print();

        Assertions.assertThat(print).isEqualTo("pobi : -");
    }
}