package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.RandomMoveStrategy;

@DisplayName("RandomMoveStrategy 무작위 전진 조건 테스트")
public class RandomMoveStrategyTest {

    @Test
    @DisplayName("전진 조건이 무작위로 충족되는지 확인")
    void testCanMove() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();

        boolean canMoveResult = false;
        for (int i = 0; i < 100; i++) {
            if (strategy.canMove()) {
                canMoveResult = true;
                break;
            }
        }
        assertTrue(canMoveResult, "전진 조건이 정상적으로 충족되어야 합니다.");
    }
}