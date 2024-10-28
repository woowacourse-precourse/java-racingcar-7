package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Nested
    @DisplayName("자동차 이동")
    class CarMoveTest {

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("랜덤값이 4 이상이면 전진한다")
        void moveForwardWhenNumberIsGreaterThanThreshold(int number) {
            Car car = new Car("pobi");
            car.move(number);
            assertEquals(1, car.getPosition());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("랜덤값이 4 미만이면 멈춘다")
        void stayWhenNumberIsLessThanThreshold(int number) {
            Car car = new Car("pobi");
            car.move(number);
            assertEquals(0, car.getPosition());
        }
    }
}

