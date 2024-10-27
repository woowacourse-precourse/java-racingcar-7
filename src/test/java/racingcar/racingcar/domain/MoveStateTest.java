package racingcar.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.move.MoveConstant;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class MoveStateTest {
    @Test
    @DisplayName("4 이상만 움직이는지")
    void moveAbleTest() {
        List<Integer> moveInput = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Boolean> expectedValue = List.of(false, false, false, false, true, true, true, true, true, true);
        for (int i = MoveConstant.MIN_MOVE_RANGE; i <= MoveConstant.MAX_MOVE_RANGE; i++) {
            assertThat(MoveState.isMove(moveInput.get(i))).isEqualTo(expectedValue.get(i));
        }
    }
}
