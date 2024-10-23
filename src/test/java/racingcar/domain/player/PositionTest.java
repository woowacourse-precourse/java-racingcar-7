package racingcar.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    Position position;

    @Test
    @DisplayName("자동차의 현재 위치를 증가 시킨다.")
    void 현재_위치를_증가시키는_기능() {
        //given
        position = new Position();

        //when
        int currentPosition = position.addPosition();

        //then
        Assertions.assertThat(currentPosition).isEqualTo(1);
    }

}