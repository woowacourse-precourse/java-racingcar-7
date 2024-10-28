package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {

    @Test
    @DisplayName("랜덤 이동 조건 테스트")
    void testMoveCondition() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        // 이동 조건을 테스트하기 위해 여러 번 반복하여 4 이상이 나오는지를 확인
        boolean canMoveAtLeastOnce = false;
        for (int i = 0; i < 300; i++) {
            if (moveStrategy.canMove()) {
                canMoveAtLeastOnce = true;
                break;
            }
        }

        assertThat(canMoveAtLeastOnce).isTrue();
    }
}
