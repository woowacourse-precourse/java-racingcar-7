package racingcar.race;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThresholdMoveStrategyTest {
    @Test
    void 전진_성공_테스트() {
        NumberGenerator numberGenerator = () -> 5;
        RaceMoveStrategy raceMoveStrategy = new ThresholdMoveStrategy(numberGenerator, 4);
        Assertions.assertEquals(true, raceMoveStrategy.canMove());
    }

    @Test
    void 전진_실패_테스트() {
        NumberGenerator numberGenerator = () -> 3;
        RaceMoveStrategy raceMoveStrategy = new ThresholdMoveStrategy(numberGenerator, 4);
        Assertions.assertEquals(false, raceMoveStrategy.canMove());
    }
}
