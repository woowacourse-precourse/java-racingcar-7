package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class DuplicateNameValidatorTest {

    private final DuplicateNameValidator validator = new DuplicateNameValidator();

    @Test
    void validate_WhenDuplicateNames_ShouldThrowException() {
        List<String> names = Arrays.asList("pobi", "woni", "pobi");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(names))
                .withMessage(ErrorMessage.DUPLICATE_NAME.getMessage());
    }

    @Test
    void validate_WhenUniqueNames_ShouldNotThrowException() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        validator.validate(names); // 예외가 발생하지 않아야 함
    }

}
