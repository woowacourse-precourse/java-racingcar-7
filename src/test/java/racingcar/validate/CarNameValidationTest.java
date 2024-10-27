package racingcar.validate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarNameValidationTest {

    static Stream<Arguments> provideInvalidCarNames() {
        return Stream.of(
                Arguments.of(List.of("pobiiii", "woni", "jun")),
                Arguments.of(List.of("", "woni", "jun")),
                Arguments.of(Arrays.asList(null, "woni", "jun")),
                Arguments.of(List.of("car1", "car1", "car2")),
                Arguments.of(List.of("car ", "car2", "car3")),
                Arguments.of(List.of("ca r1", "car2", "car3")),
                Arguments.of(List.of(" car1", "car2", "car3")),
                Arguments.of(List.of("car1", "car2", "car4\n")),
                Arguments.of(List.of("car1", "car5\n", "car3"))
        );
    }

    static Stream<Arguments> provideValidCarNames() {
        return Stream.of(
                Arguments.of(List.of("pobii", "wonii", "junn")),
                Arguments.of(List.of("a", "b", "c")),
                Arguments.of(List.of("car1", "car2")),
                Arguments.of(List.of("1", "2", "3")),
                Arguments.of(List.of("1"))
        );
    }

    @DisplayName("이름 조건에 만족하지 않는 경우_예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidCarNames")
    void Input_Car_Names_Invalid_Condition(List<String> carNames) {
        assertThrows(IllegalArgumentException.class, () -> CarNameValidation.validateName(carNames));
    }

    @DisplayName("이름 조건 만족하는 경우_예외 발생하지 않음")
    @ParameterizedTest
    @MethodSource("provideValidCarNames")
    void Input_Car_Names_Valid_Condition(List<String> carNames) {
        assertDoesNotThrow(() -> CarNameValidation.validateName(carNames));

    }

}
