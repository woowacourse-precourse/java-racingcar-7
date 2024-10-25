package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.helper.ReflectionUtil.forceSetField;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("[전진] 2바퀴 돌았고, 3번째 바퀴 돌때")
    void moveForward() {
        // given
        Position position = Position.initiate();
        forceSetField(position, "value", "---");

        // when
        position.add(Distance.ONE);

        // then
        assertThat(position.toString()).isEqualTo("----");
    }

    @Test
    @DisplayName("[정지] 2바퀴 돌았고, 3번째 바퀴 돌때")
    void noMovement() {
        // given
        Position position = Position.initiate();
        forceSetField(position, "value", "---");

        // when
        position.add(Distance.ZERO);

        // then
        assertThat(position.toString()).isEqualTo("---");
    }
}
