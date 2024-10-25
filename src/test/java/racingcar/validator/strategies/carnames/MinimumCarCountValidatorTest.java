package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class MinimumCarCountValidatorTest {

    private final MinimumCarCountValidator validator = new MinimumCarCountValidator();

    @Test
    void validate_WhenCarCountLessThanMinimum_ShouldThrowException() {
        List<String> names = Collections.singletonList("pobi"); // 최소 2개가 필요하다고 가정
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(names))
                .withMessage(ErrorMessage.MINIMUM_CARS.getMessage());
    }

    @Test
    void validate_WhenCarCountMeetsMinimum_ShouldNotThrowException() {
        List<String> names = List.of("pobi", "woni");
        validator.validate(names); // 예외가 발생하지 않아야 함
    }

}
