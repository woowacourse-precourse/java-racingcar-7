package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("전진하면 1칸 앞으로 이동한다")
    @Test
    void 위치_전진() {
        var zero = Position.zero();

        assertThat(zero.moveForward()).isEqualTo(Position.from(1));
    }

}
