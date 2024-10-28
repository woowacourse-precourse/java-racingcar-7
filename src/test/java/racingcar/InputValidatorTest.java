package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void validateCarNamesThrowsExceptionForEmptyNames() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(new String[]{""}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNamesThrowsExceptionForTooLongNames() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(new String[]{"TooLongName"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMoveCountThrowsExceptionForNonPositiveNumber() {
        assertThatThrownBy(() -> InputValidator.validateMoveCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
