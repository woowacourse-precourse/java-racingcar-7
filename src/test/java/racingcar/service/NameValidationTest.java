package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameValidationTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외가 발생해야 한다")
    void validateCarNames_lengthExceeded_shouldThrowException() {
        // given
        NameValidationService nameValidationService = new NameValidationService();
        String invalidCarName = "pobidori";

        // when & then
        assertThatThrownBy(() -> nameValidationService.validateCarNames(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    @DisplayName("자동차 이름이 공백일 때 예외가 발생해야 한다")
    void validateCarNames_empty_shouldThrowException() {
        NameValidationService nameValidationService = new NameValidationService();
        String emptyCarName = "   "; // 공백 문자열

        assertThatThrownBy(() -> nameValidationService.validateCarNames(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_CAR_NAME_EMPTY);
    }

    @Test
    @DisplayName("입력받은 자동차 이름이 중복일 때 예외가 발생해야 한다")
    void createGame_whenDuplicateCarNames_shouldThrowException() {
        // Given
        CarService carService = new CarService();
        String duplicateCarNames = "pobi,pobi,woni";  // 중복된 자동차 이름 포함

        // When & Then
        assertThatThrownBy(() -> carService.createGame(duplicateCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.DUPLICATE_CAR_NAME);
    }
}
