package racingcar.front.validator.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.app.front.error.ErrorMessage.CAR_NAME_LENGTH_EXCEED;
import static racingcar.app.server.model.car.Car.CAR_NAME_MIN_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.front.validator.car.CarNameLengthValidator;
import racingcar.app.server.exception.LengthExceedException;

public class CarNameLengthValidatorTest {

    private final CarNameLengthValidator validator = CarNameLengthValidator.initiate();

    @Test
    @DisplayName("길이가 5")
    void normalCase1() {
        // given
        String source = "gil, kevin";

        // when & then
        assertDoesNotThrow(
                () -> validator.check(source)
        );
    }

    @Test
    @DisplayName("길이가 7")
    void exceedMinLength() {
        // given
        String source = "gilbert9172, kevin";
        // when & then
        assertThrows(
                LengthExceedException.class,
                () -> validator.check(source),
                String.format(CAR_NAME_LENGTH_EXCEED, CAR_NAME_MIN_LENGTH)
        );
    }
}
