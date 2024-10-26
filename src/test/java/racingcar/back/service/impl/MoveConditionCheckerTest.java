package racingcar.back.service.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveConditionCheckerTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("난수 발생을 4로 정했을 때 Validator가 true를 반환하는지 체크하는 테스트")
    void 움직임_난수_체크_테스트1() {
        //given
        int movingForward = 4;
        //when
        //then
        assertRandomNumberInRangeTest(() -> {
            Boolean movable = MoveConditionChecker.isMovable();
            assertThat(movable).isEqualTo(true);
        }, movingForward);
    }

    @Test
    @DisplayName("난수 발생을 3으로 정했을 때 Validator가 false를 반환하는지 체크하는 테스트")
    void 움직임_난수_가능_체크_테스트2() {
        //given
        int stop = 3;
        //when
        //then
        assertRandomNumberInRangeTest(() -> {
            Boolean movable = MoveConditionChecker.isMovable();
            assertThat(movable).isEqualTo(false);
        }, stop);
    }
}