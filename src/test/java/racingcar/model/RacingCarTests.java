package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTests {

    private static final int CURRENT_TRIAL = 1;
    private static final int MOVING_FORWARD = 4;
    private static final int MOVED = 1;

    private static final int STOP = 3;
    private static final int NOT_MOVED = 0;

    private static RacingCar racingCarSample;

    @BeforeEach
    void setUp() {
        racingCarSample = new RacingCar("racer");
    }

    @Test
    @DisplayName("4 이상의 무작위 수를 뽑은 경우 자동차의 현재 전진 횟수는 1 증가")
    void testMoveIfFourOrMore() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarSample.moveOrStop();
                    Assertions.assertThat(racingCarSample.getCurrentDistance(CURRENT_TRIAL)).isEqualTo(MOVED);
                }, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("4 미만의 무작위 수를 뽑은 경우 자동차의 현재 전진 횟수는 증가하지 않음")
    void testStopWhenLessThanFour() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarSample.moveOrStop();
                    Assertions.assertThat(racingCarSample.getCurrentDistance(CURRENT_TRIAL)).isEqualTo(NOT_MOVED);
                }, STOP
        );
    }
}