package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConditionCheckerTest {

    @Test
    @DisplayName("입력된 값이 4보다 크거나 같으면 이동할 수 있다고 판단한다")
    void canMoveForwardWhenValueIsMoreThanOrEqualToFour() {
        // given
        int value = 4;

        // when
        boolean canMove = ConditionChecker.canMove(value);

        // then
        assertThat(canMove).isTrue();

    }

    @Test
    @DisplayName("입력된 값이 4보다 작으면 이동할 수 없다고 판단한다")
    void cannotMoveForwardWhenValueIsLessThanFour() {
        // given
        int value = 3;

        // when
        boolean canMove = ConditionChecker.canMove(value);

        // then
        assertThat(canMove).isFalse();
    }

}