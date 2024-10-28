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
        assertThatThrownBy(() -> carService.setMoveCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.INVALID_MOVE_COUNT);
    }
}
