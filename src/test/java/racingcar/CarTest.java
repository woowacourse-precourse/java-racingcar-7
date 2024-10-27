package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"4", "10", "100", "1000000000"})
    @DisplayName("Car의 moveCondition보다 큰 값이 주어지면 움직일 수 있음")
    void moveSuccess(int value) {
        Car car = new Car("car", 0, 4);
        car.move(value);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "3"})
    @DisplayName("Car의 moveCondition보다 작은 값이면 움직일 수 없음")
    void moveFail(int value) {
        Car car = new Car("car", 0, 4);
        car.move(value);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car name is returned correctly")
    void carNameIsReturnedCorrectly() {
        Car car = new Car("pobi", 0, 4);
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("Car position is returned correctly")
    void carPositionIsReturnedCorrectly() {
        Car car = new Car("pobi", 5, 4);
        Assertions.assertThat(car.getPosition()).isEqualTo(5);
    }

}