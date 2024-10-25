package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.position.Distance;

public class MovementTest {

    @Test
    @DisplayName("random 값 4 : 전진")
    void moveForwardV2() {
        // given
        int movementValue = 4;

        // when
        Distance actual = MovementCondition.getConditionBy(movementValue).getDistance();

        // then
        assertThat(actual.equals(Distance.ONE)).isTrue();
    }


    @Test
    @DisplayName("random 값 3 : 이동 하지 않음")
    void doNotMove() {
        // given
        int movementValue = 3;

        // when
        Distance actual = MovementCondition.getConditionBy(movementValue).getDistance();

        // then
        assertThat(actual.equals(Distance.ZERO)).isTrue();
    }
}
