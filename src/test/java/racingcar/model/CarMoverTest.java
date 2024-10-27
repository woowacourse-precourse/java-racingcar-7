package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoverTest {
    private final CarMover carMover = new CarMover();

    @DisplayName("무작위 값이 4 이상일 경우 자동차가 전진")
    @Test
    void carMovesWhenRandomValueIsGreaterThanOrEqualTo4() {
        boolean canMoveForValue5 = carMover.canMove(5);
        boolean canMoveForValue3 = carMover.canMove(3);

        assertThat(canMoveForValue5).isTrue();
        assertThat(canMoveForValue3).isFalse();
    }
}
