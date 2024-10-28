package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.AppConstants;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차 객체는 이름을 갖는다")
    @ParameterizedTest
    @MethodSource("provideValidCarNames")
    void carHasName(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 없거나 길이가 초과되면 예외를 던진다")
    @ParameterizedTest
    @MethodSource("provideInvalidCarNames")
    void invalidCarNameThrowsException(String invalidName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(invalidName))
                .withMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @DisplayName("랜덤 값이 이동 조건에 맞으면 자동차가 전진한다")
    @ParameterizedTest
    @MethodSource("provideRandomValuesForMove")
    void carMovesForwardWhenRandomConditionIsMet(int randomValue, int expectedPosition) {
        Car car = new Car("car1");
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    static Stream<Arguments> provideValidCarNames() {
        return Stream.of(
                Arguments.of("car1"),
                Arguments.of("a"),
                Arguments.of("z1234")
        );
    }

    static Stream<Arguments> provideInvalidCarNames() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("loooongname"),
                Arguments.of("123456")
        );
    }

    static Stream<Arguments> provideRandomValuesForMove() {
        return Stream.of(
                Arguments.of(AppConstants.MOVE_THRESHOLD, 1),
                Arguments.of(AppConstants.MOVE_THRESHOLD - 1, 0)
        );
    }
}
