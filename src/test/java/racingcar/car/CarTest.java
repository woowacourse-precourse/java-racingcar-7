package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @DisplayName("0~9 사이의 랜덤 숫자를 구해 4이상인 경우 자동차를 전진시킨다.")
    @ParameterizedTest
    @CsvSource({"3, 0", "4, 1", "9, 1"})
    void moveForward(int randomNumber, int expectedMoveCount) {
        Car car = new Car("car1");

        if (randomNumber >= 4) {
            car.moveForward();
        }

        assertThat(car.getCurrentMoveCount()).isEqualTo(expectedMoveCount);
    }

    @DisplayName("입력된 자동차가 1대일 때, 자동차 이름을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1"})
    void getNameWhenInputIsOne(String value) {
        Car car = new Car(value);
        Assertions.assertEquals(car.getName(), value);
    }

    @DisplayName("입력된 자동차가 2대 이상일 때, 자동차 이름을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    void getNameWhenInputIsTwoOrMore(String value) {
        Car car = new Car(value);
        Assertions.assertEquals(car.getName(), value);
    }

    @DisplayName("자동차의 현재 이동 횟수를 반환한다.")
    @Test
    void getCurrentMoveCount() {
        Car car = new Car("car1");

        car.moveForward();
        car.moveForward();
        car.moveForward();

        int currentMoveCount = car.getCurrentMoveCount();
        Assertions.assertTrue(currentMoveCount >= 0 && currentMoveCount <= 3);
    }
}