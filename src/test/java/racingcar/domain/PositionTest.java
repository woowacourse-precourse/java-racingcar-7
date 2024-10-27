package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void 위치는_음수일수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }

    @Test
    public void 위치의_기본값은_0이다() {
        assertThat(Position.defaultInstance()).isEqualTo(new Position(0));
    }

    @Test
    public void 위치를_한칸_이동한다() {
        Position position = Position.defaultInstance();
        assertThat(position.increase()).isEqualTo(new Position(1));
    }
}
