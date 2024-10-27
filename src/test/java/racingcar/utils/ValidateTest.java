package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class ValidateTest {
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    @Test
    void validateNameLength() {
        String carNames = "pobi,woni,junjun";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.registerCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NAME_LENGTH_OVER_LIMIT_MESSAGE);
    }
}
