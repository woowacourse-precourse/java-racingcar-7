package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_FORMAT;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

class CarNameValidatorTest {

    @Test
    @DisplayName("이름이 5자를 초과할 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenNameExceedsMaxLength() {
        // Given
        String name = "pobiii";

        // When & Then
        assertThrows(RacingException.class, () ->
                CarNameValidator.validateCarName(name)
        );

        assertThatThrownBy(() -> CarNameValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름이 알파벳과 숫자 이외의 문자를 포함할 경우 예외 발생해야 한다.")
    void shouldThrowExceptionWhenNameContainsInvalidCharacters() {
        // Given
        String name = "pob@1";

        // When & Then
        assertThatThrownBy(() -> CarNameValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_FORMAT.getMessage());
    }
}