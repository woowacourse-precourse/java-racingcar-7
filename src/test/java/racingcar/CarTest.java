package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void createCar() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 기능 테스트")
    void moveCar() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}