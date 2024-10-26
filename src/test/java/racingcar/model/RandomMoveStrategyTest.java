package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {

    @DisplayName("랜덤 숫자에 따른 true, false 반환")
    @Test
    public void RandomNumberReturnTrue() {
        //given
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        //when
        boolean canMove = moveStrategy.canMove();
        //then
        assertThat(canMove).isIn(true, false);
    }
}
