package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @Test
    @DisplayName("입력이 비어있을 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsEmpty() {
        // Given
        String input = "";

        // When & Then
        assertThrows(RacingException.class, () ->
                InputValidator.validateEmpty(input)
        );
    }

    @Test
    @DisplayName("중복된 이름이 존재할 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenDuplicateNamesExist() {
        // Given
        List<String> names = Arrays.asList("pobi", "woni", "pobi");

        // When & Then
        assertThrows(RacingException.class, () ->
                InputValidator.validateDuplicate(names)
        );
    }

    @Test
    @DisplayName("최소 자동차 개수보다 적을 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenLessThanMinimumCarCount() {
        // Given
        List<String> names = List.of("pobi");

        // When & Then
        assertThrows(RacingException.class, () ->
                InputValidator.validateDuplicate(names)
        );
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsNotNumeric() {
        // Given
        String input = "abc";

        // When & Then
        assertThrows(RacingException.class, () ->
                InputValidator.validateNumeric(input)
        );
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenInputIsNegative() {
        // Given
        String input = "-1";

        // When & Then
        assertThrows(RacingException.class, () ->
                InputValidator.validateNumeric(input)
        );
    }
}