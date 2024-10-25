package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomMoveStrategyTest {

    private final MoveStrategy moveStrategy = new RandomMoveStrategy();

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4 이상일 때 이동 가능한다.")
    void 이동_성공(int randomNumber) {
        assertRandomNumberInRangeTest(() -> {
            assertThat(moveStrategy.canMove()).isTrue();
        }, randomNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 3 이하일 때 이동 불가능하다.")
    void 이동_실패(int randomNumber) {
        assertRandomNumberInRangeTest(() -> {
            assertThat(moveStrategy.canMove()).isFalse();
        }, randomNumber);
    }
}