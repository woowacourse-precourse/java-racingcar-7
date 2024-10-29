package racingcar.front.validator.car;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.app.front.error.ErrorMessage.EMPTY_INPUT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.front.exception.EmptyInputException;
import racingcar.app.front.validator.car.CarNameNullValidator;

public class CarNameNullValidatorTest {

    private final CarNameNullValidator validator = CarNameNullValidator.initiate();

    @Test
    @DisplayName("아무것도 입력하지 않음 : empty string")
    void emptyInputEmptyString() {
        // given
        String source = "";
        // when & then
        assertThrows(
                EmptyInputException.class,
                () -> validator.check(source),
                EMPTY_INPUT
        );
    }

    @Test
    @DisplayName("아무것도 입력하지 않음 : null")
    void emptyInputNull() {
        // given
        String source = null;
        // when & then
        assertThrows(
                EmptyInputException.class,
                () -> validator.check(source),
                EMPTY_INPUT
        );
    }

    @Test
    @DisplayName("아무것도 입력하지 않음 : 공백")
    void emptyInputWhiteSpace() {
        // given
        String source = "            ";
        // when & then
        assertThrows(
                EmptyInputException.class,
                () -> validator.check(source),
                EMPTY_INPUT
        );
    }
}
