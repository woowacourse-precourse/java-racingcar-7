package racingcar.validate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputNumberValidationTest {

    static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.of("10 "),
                Arguments.of("0123"),
                Arguments.of("12 3"),
                Arguments.of(" 4320"),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("1234\n"),
                Arguments.of((String) null)
        );
    }

    static Stream<Arguments> provideValidNumbers() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("10"),
                Arguments.of("902")

        );
    }

    @DisplayName("숫자 조건에 맞지 않는 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void Input_Number_Contains_Invalid_Element(String inputNumber) {
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidation.validateInputNumber(inputNumber));
    }

    @DisplayName("숫자 조건에 맞는 경우")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    void Input_Number_Contains_Valid_Element(String inputNumber) {
        assertDoesNotThrow(() -> InputNumberValidation.validateInputNumber(inputNumber));
    }
}
