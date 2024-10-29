package racingcar.front.validator.lap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.front.exception.LoeZeroException;
import racingcar.app.front.validator.lap.NumberFormatValidator;

public class NumberFormatValidatorTest {

    private final NumberFormatValidator validator = NumberFormatValidator.initiate();

    @Test
    @DisplayName("-1 인 경우")
    void negativeNumber() {
        // given
        String source = "-1";
        // when & then
        assertThrows(
                LoeZeroException.class,
                () -> validator.check(source)
        );
    }

    @Test
    @DisplayName("1인 경우")
    void one() {
        // given
        String source = "1";
        // when & then
        assertDoesNotThrow(
                () -> validator.check(source)
        );
    }
}
