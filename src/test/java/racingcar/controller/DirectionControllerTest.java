package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Direction;

public class DirectionControllerTest {

    private final DirectionController directionController = new DirectionController();

    @Test
    @DisplayName("전진하는 조건은 무작위 값이 4 이상일 경우이다.")
    void 랜덤값이_4이상이면_전진한다() {
        Assertions.assertThat(directionController.determineDirectionUsingThreshold(5))
                .isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("무작위 값이 4미만 일 경우 방향 없음을 반환한다.")
    void 랜덤값이_4이하이면_NO_DIRECTION을_반환한다() {
        Assertions.assertThat(directionController.determineDirectionUsingThreshold(2))
                .isEqualTo(Direction.STOP);
    }

}
