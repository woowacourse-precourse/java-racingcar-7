package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    // 올바르지 않은 이름에 대한 예외 테스트
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "우아한테크코스", "qwerty", "", " ", "   "})
    void throwExceptionIfNameIsInvalid(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 입력한 숫자에 따라서 위치가 제대로 변경되는 지 테스트
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1"
    })
    void shouldReturnCorrectLocation(int number, int location) {
        Car car = new Car("A");
        car.move(number);

        Assertions.assertThat(car.getLocation())
                .isEqualTo(location);
    }

    @Test
    void shouldBeEqualWhenNamesMatch() {
        Car car1 = new Car("A");
        Car car2 = new Car("A");

        Assertions.assertThat(car1).isEqualTo(car2);
    }
}
