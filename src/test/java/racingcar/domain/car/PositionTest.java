package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("위치를 이동한다.")
    @Test
    void move() {
        //given
        Position position = new Position(0);

        //when
        Position result = position.move();

        //then
        assertThat(result).isEqualTo(new Position(1));
    }
}