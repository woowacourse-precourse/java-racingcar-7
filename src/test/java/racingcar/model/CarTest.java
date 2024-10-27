package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.function.DoubleBinaryOperator;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void radonNumberGenerateTest() {

        int randomNumber = Car.randomNumberGenerator();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void carMoveMoreThanFour() {
        Car car = Car.create("jiwon");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carMoveLessThanFour() {
        Car car = Car.create("jiwon");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}