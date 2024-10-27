package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

public class PositionTest {
    @Test
    @DisplayName("Position은 음수가 될 수 없다.")
    void validatePosition_Test() {
        //expected
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_POSITION.getMessage());
    }

    @Test
    @DisplayName("forward 메소드를 실행하면 value값이 증가해야한다.")
    void forward_Test() {
        //given
        Position position = new Position(0);

        //when
        position.forward();
        position.forward();
        position.forward();
        position.forward();

        //then
        Assertions.assertThat(position.getValue()).isEqualTo(4);
    }
}
