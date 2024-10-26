package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("자동차 유효성 테스트")
class CarValidatorTest {
    @Test
    @DisplayName("자동차 이름이 5자 이하일 때")
    void validateCarNameLength() {
        assertDoesNotThrow(() -> {
            CarValidator.validateCar("jjang");
        });
    } // validateCarNameLength

    @Test
    @DisplayName("자동차 이름이 5자 초과할 때 예외가 발생하는지")
    void carNameLengthException() {
        assertThatThrownBy(() -> {
            CarValidator.validateCar("jjangi");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MAX_LENGTH_IS_FIVE);
    } // carNameLengthException

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름이 공백일 때 예외가 발생하는지")
    void carNameBlankException(String input) {
        assertThatThrownBy(() -> {
            CarValidator.validateCar(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MUST_BE_FILLED);
    } // carNameBlankException
} // class