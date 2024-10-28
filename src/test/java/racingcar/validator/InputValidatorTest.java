package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.*;

class InputValidatorTest {

    @Test
    @DisplayName("입력이 비어있을 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsEmpty() {
        // Given
        String input = "";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 존재할 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenDuplicateNamesExist() {
        // Given
        List<String> names = Arrays.asList("pobi", "woni", "pobi");

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateDuplicate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("최소 자동차 개수보다 적을 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenLessThanMinimumCarCount() {
        // Given
        List<String> names = List.of("pobi");

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateDuplicate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MINIMUM_NUMBER_OF_CARS.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsNotNumeric() {
        // Given
        String input = "abc";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ATTEMPT_COUNT_FORMAT.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsNegative() {
        // Given
        String input = "-1";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NUMBER.getMessage());
    }
}