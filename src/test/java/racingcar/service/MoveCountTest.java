package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountTest {
    @Test
    @DisplayName("시도할 횟수가 1 미만일 때 예외가 발생해야 한다")
    void setMoveCount_lessThanOne_shouldThrowException() {
        // given
        CarService carService = new CarService();

        // when & then
        assertThatThrownBy(() -> carService.setMoveCount(String.valueOf(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_MOVE_COUNT);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 예외가 발생해야 한다")
    void setMoveCount_whenNotANumber_shouldThrowException() {
        // Given
        CarService carService = new CarService();
        String invalidMoveCount = "three";  // 숫자가 아닌 문자열 입력

        // When & Then
        assertThatThrownBy(() -> carService.setMoveCount(invalidMoveCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_MOVE_COUNT_NUMBER);
    }
}
