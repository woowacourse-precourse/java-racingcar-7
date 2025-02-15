package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 포지션이_0보다_작으면_예외_발생() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }

    @Test
    void 포지션이_증가하는지_확인() {
        Position initialPosition = new Position(0);
        Position newPosition = initialPosition.increase();

        assertThat(newPosition.value()).isEqualTo(1);
    }
}
