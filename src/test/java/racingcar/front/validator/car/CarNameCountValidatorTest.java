package racingcar.front.validator.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.front.exception.NotEnoughCarException;
import racingcar.app.front.validator.car.CarNameCountValidator;

public class CarNameCountValidatorTest {

    private final CarNameCountValidator validator = CarNameCountValidator.initiate();

    @Test
    @DisplayName("하나만 입력")
    void enterOnlyOneCarName() {
        // given
        String source = "JAVA";

        // when & then
        assertThrows(
                NotEnoughCarException.class,
                () -> validator.check(source)
        );
    }

    @Test
    @DisplayName("2개 입력")
    void normalCase1() {
        // given
        String source = "JAVA, RUBY";

        // when & then
        assertDoesNotThrow(
                () -> validator.check(source)
        );
    }
}
