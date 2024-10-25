package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class NameLengthValidatorTest {

    private final NameLengthValidator validator = new NameLengthValidator();

    @Test
    void validate_WhenNameTooLong_ShouldThrowException() {
        String name = "Ferrari"; // 예를 들어, 최대 길이가 5라고 가정
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(name))
                .withMessage(ErrorMessage.NAME_TOO_LONG.getMessage());
    }

    @Test
    void validate_WhenNameLengthValid_ShouldNotThrowException() {
        String name = "Pobi"; // 길이가 유효해야 함
        validator.validate(name); // 예외가 발생하지 않아야 함
    }
}
