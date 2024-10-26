package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class CarNameMaxLengthValidatorTest {

    private final CarNameMaxLengthValidator validator = new CarNameMaxLengthValidator();

    @Test
    void validate_WhenNameTooLong_ShouldThrowException() {
        List<String> names = List.of("Ferrari"); // 최대 길이 5라고 가정
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(names))
                .withMessage(ErrorMessage.NAME_TOO_LONG.getMessage());
    }

    @Test
    void validate_WhenNameLengthValid_ShouldNotThrowException() {
        List<String> names = List.of("Pobi", "Woni"); // 유효한 이름 길이
        assertThatNoException().isThrownBy(() -> validator.validate(names));
    }

}
