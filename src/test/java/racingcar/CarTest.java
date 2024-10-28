package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racingcar.domain.Car;

public class CarTest {

    @Test
    @DisplayName("유효한 자동차 이름 입력 - Car 객체 생성 성공")
    void testValidCar() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName);

        // then
        assertEquals(carName, car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 - Car 객체 생성 실패")
    void testInvalidCar() {
        // given
        String carName = "pobiwoni";

        // when & then
        assertThatThrownBy(() -> new Car(carName)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_TOO_LONG);
    }

    @DisplayName("자동차 이름 중에 공백 또는 빈 문자열이 있는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankCar(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME);
    }


    @DisplayName("4 이상의 값이 들어온 경우 - 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void testMoveFoward(int input) {
        // given
        Car car = new Car("test");

        // when
        car.move(input);

        // then
        assertEquals(1, car.getPosition());
    }

    @DisplayName("4 미만의 값이 들어온 경우 - 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testNotMove(int input) {
        // given
        Car car = new Car("test");

        // when
        car.move(input);

        // then
        assertEquals(0, car.getPosition());
    }


}
