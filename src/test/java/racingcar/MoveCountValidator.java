package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.MoveCountValidator;

import static org.assertj.core.api.Assertions.*;

class MoveCountValidatorTest {

    @Test
    void 숫자가_아닌_입력에_대한_예외_테스트() {
        assertThatThrownBy(() -> MoveCountValidator.getMoveCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_이동_횟수_테스트() {
        int moveCount = MoveCountValidator.getMoveCount("5");
        assertThat(moveCount).isEqualTo(5);
    }
}
