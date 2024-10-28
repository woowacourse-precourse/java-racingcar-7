package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateCarNamesTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외가 발생해야 한다")
    void validateCarNames_lengthExceeded_shouldThrowException() {
        // given
        CarService carService = new CarService();
        String invalidCarName = "pobidori";

        // when & then
        assertThatThrownBy(() -> carService.validateCarNames(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_CAR_NAME_LENGTH);
    }
}
