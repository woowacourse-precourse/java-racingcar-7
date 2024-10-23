package racingcar.domain.player;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("자동차의 위치를 비교 하여 더 클 경우 True를 반환 한다.")
    void 자동차의_현재_위치를_비교하는_기능() {
        //given
        Position poviCarPosition = new Position();
        Position minuCarPosition = new Position();

        //when
        poviCarPosition.addPosition();

        //then
        assertTrue(poviCarPosition.isGreaterThan(minuCarPosition));
    }
}