package racingcar.server.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.app.server.error.ErrorMessage.DISTANCE_SHOULD_NOT_BE_MINUS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.exception.ShouldNotBeMinusException;
import racingcar.app.server.model.location.Position;

public class PositionTest {

    @Test
    @DisplayName("distance 7일 때")
    void convertDistanceToPositionCase1() {
        // given
        long distance = 7;
        Position expected = Position.from("-------");

        // when
        Position actual = Position.convertFromDistance(distance);

        // then
        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    @DisplayName("distance -1일 때")
    void convertDistanceToPositionCase2() {
        // given
        long distance = -1;

        // when & then
        Assertions.assertThrows(
                ShouldNotBeMinusException.class,
                () -> Position.convertFromDistance(distance),
                DISTANCE_SHOULD_NOT_BE_MINUS
        );
    }

    @Test
    @DisplayName("distance 0일 때")
    void convertDistanceToPositionCase3() {
        // given
        long distance = 0;
        Position expected = Position.from("");

        // when
        Position actual = Position.convertFromDistance(distance);

        // then
        assertThat(actual.equals(expected)).isTrue();
    }
}
