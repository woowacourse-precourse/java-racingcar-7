package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.ErrorMessage;

class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("provideBlankOrNullInputs")
    @DisplayName("공백 또는 null 입력 시 IllegalArgumentException이 발생한다.")
    void validateBlank_ThrowsException_WhenInputIsNotBlankOrNull(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_CAR_NAME.getMessage());
    }

    private static Stream<Arguments> provideBlankOrNullInputs() {
        return Stream.of(
                Arguments.of((String) null),              // null 입력
                Arguments.of(""),             // 빈 문자열
                Arguments.of("   ")           // 공백 문자열
        );
    }

    @ParameterizedTest
    @CsvSource({"abc", "-123", "12.3"})
    @DisplayName("양의 정수가 아닌 경우 IllegalArgumentException이 발생한다.")
    void validatePositiveInteger_ThrowsException_WhenInputIsNotTrialCount(String input) {
        assertThatThrownBy(() -> InputValidator.validateTrialCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideBlankOrNullInputs")
    @DisplayName("null 또는 공백 입력 시 validatePositiveInteger에서도 예외가 발생한다.")
    void validateTrialCount_Input_ThrowsException_WhenInputIsBlankOrNull(String input) {
        assertThatThrownBy(() -> InputValidator.validateTrialCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"123", "456", "789"})
    @DisplayName("올바른 양의 정수 입력 시 예외가 발생하지 않는다.")
    void validateTrialCount_Input_DoesNotThrowException_WhenInputIsValid(String input) {
        assertDoesNotThrow(() -> InputValidator.validateTrialCountInput(input));
    }
}
