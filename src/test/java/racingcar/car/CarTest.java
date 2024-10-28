package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    @Test
    @DisplayName("자동차의 현재 이동거리를 입력받은 문자로 표현한다")
    void showCurrentCarPositionalStatusTest() {
        // given
        Car car = Car.from("test");
        String symbol = "-";
        int value = 5;
        // when
        car.tryMoveForward(value, 1);
        String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(symbol);

        // then
        assertThat(currentPositionalVisualStatus).isEqualTo("test" + " : " + "-");
    }

    @ParameterizedTest
    @MethodSource("invalidCarNames")
    @DisplayName("요구사항에 맞지 않는 자동차 이름을 사용할 수 없다")
    void invalidCarNamesThrowsExceptions(String carName, String expectedErrorMessage) {

        // when, then
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);

    }

    private static Stream<Arguments> invalidCarNames() {
        return Stream.of(
                Arguments.arguments("", "자동차 이름은 비워둘 수 없습니다."),
                Arguments.arguments("   ", "자동차 이름은 공백일 수 없습니다."),
                Arguments.arguments("abcdefg", "자동차 이름은 5자 이하여야 합니다.")
        );
    }
}