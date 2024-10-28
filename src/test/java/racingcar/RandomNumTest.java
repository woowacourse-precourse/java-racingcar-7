package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumManager;

public class RandomNumTest {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;

    @Test
    void 랜덤으로_생성한_숫자는_0과_9사이의_숫자여야한다() {
        int randomNumber = RandomNumManager.generateRandomNumber();
        assertThat(randomNumber).isBetween(LOWER_BOUND, UPPER_BOUND);
    }

    @Test
    void 랜덤숫자가_4일_경우_전진가능하므로_True_반환() {
        boolean result = RandomNumManager.isSatisfyForwardCondition(MOVE_FORWARD_CONDITION);
        assertThat(result).isTrue();
    }

    @Test
    void 랜덤숫자가_4보다_클_경우_전진가능하므로_True_반환() {
        // 조건보다 클 때 true를 반환해야 함
        boolean result = RandomNumManager.isSatisfyForwardCondition(MOVE_FORWARD_CONDITION + 1);
        assertThat(result).isTrue();
    }

    @Test
    void 랜덤숫자가_4보다_작을_경우_전진불가능하므로_False_반환() {
        // 조건보다 작을 때 false를 반환해야 함
        boolean result = RandomNumManager.isSatisfyForwardCondition(MOVE_FORWARD_CONDITION - 1);
        assertThat(result).isFalse();
    }

}
