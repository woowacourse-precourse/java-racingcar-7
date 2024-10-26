package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 객체 테스트")
class CarsTest {
    @Test
    @DisplayName("생성된 무작위 값이 0~9 사이인지")
    void generateRandomNumber() {
        Car car = new Car("pobi");
        Cars cars = new Cars(List.of(car));

        assertThat(cars.getPower()).isBetween(0, 9);
    } // generateRandomNumber
} // class