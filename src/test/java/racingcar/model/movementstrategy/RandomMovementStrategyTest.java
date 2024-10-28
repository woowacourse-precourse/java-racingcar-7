package racingcar.model.movementstrategy;

import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.movementstrategy.RandomMovementStrategy.MOVE_MIN_NUMBER;

class RandomMovementStrategyTest {
    private MovementStrategy randomMovementStrategy = new AppConfig().movement();

    @Test
    void 특정_숫자_이상이면_true() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean isMove = randomMovementStrategy.isMove();
                    assertThat(isMove).isTrue();
                },
                MOVE_MIN_NUMBER
        );
    }

    @Test
    void 특정_숫자_미만이면_false() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean isMove = randomMovementStrategy.isMove();
                    assertThat(isMove).isFalse();
                },
                MOVE_MIN_NUMBER - 1
        );
    }
}