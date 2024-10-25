package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.helper.ReflectionUtil.forceSetField;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.position.Distance;
import racingcar.model.position.Position;

public class PositionTest {

    @Test
    @DisplayName("[전진] 2바퀴 돌았고, 3번째 바퀴 돌때")
    void moveForward() {
        // given
        Position position = Position.initiate();
        forceSetField(position, "value", "---");

        // when
        Position actual = position.add(Distance.ONE);

        // then
        Position expected = Position.from("----");
        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    @DisplayName("[정지] 2바퀴 돌았고, 3번째 바퀴 돌때")
    void noMovement() {
        // given
        Position position = Position.initiate();
        forceSetField(position, "value", "---");

        // when
        Position actual = position.add(Distance.ZERO);

        // then
        Position expected = Position.from("---");
        assertThat(actual.equals(expected)).isTrue();
    }
}
