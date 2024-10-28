package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    void Car_거리반환_테스트() {
        assertThat(car.getDistance())
                .isEqualTo(0);
    }

    @Test
    void Car_이름반환_테스트() {
        assertThat(car.getName())
                .isEqualTo("testCar");
    }

    @Test
    void Car_거리업데이트_테스트() {
        car.addDistance();
        assertThat(car.getDistance())
                .isEqualTo(1);
    }

}
