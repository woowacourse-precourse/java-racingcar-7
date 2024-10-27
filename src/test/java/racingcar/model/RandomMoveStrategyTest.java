package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {
    @DisplayName("랜덤 숫자에 따른 반환값 테스트(False)")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void RandomNumberReturnFalse(int randomNumber) {
        assertRandomNumberInRangeTest(() -> {
            // given
            MoveStrategy moveStrategy = new RandomMoveStrategy();

            // when
            boolean canMove = moveStrategy.canMove();

            // then
            assertThat(canMove).isEqualTo(false);
        }, randomNumber);
    }
    @DisplayName("랜덤 숫자에 따른 반환값 테스트(True)")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void RandomNumberReturnTrue(int randomNumber) {
        assertRandomNumberInRangeTest(() -> {
            // given
            MoveStrategy moveStrategy = new RandomMoveStrategy();

            // when
            boolean canMove = moveStrategy.canMove();

            // then
            assertThat(canMove).isEqualTo(true);
        }, randomNumber);
    }
}
