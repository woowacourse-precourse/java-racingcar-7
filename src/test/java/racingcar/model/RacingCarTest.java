package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;
import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void 전진하면_위치가_1_늘어난다() {
        RacingCar racingCar = new RacingCar("pobi");
        int initialPos = racingCar.getPosition();

        racingCar.moveForward(() -> 0);
        assertThat(racingCar.getPosition()).isEqualTo(initialPos);

        racingCar.moveForward(() -> 3);
        assertThat(racingCar.getPosition()).isEqualTo(initialPos);

        racingCar.moveForward(() -> 4);
        assertThat(racingCar.getPosition()).isEqualTo(initialPos + 1);

        racingCar.moveForward(() -> 6);
        assertThat(racingCar.getPosition()).isEqualTo(initialPos + 2);

        racingCar.moveForward(() -> 9);
        assertThat(racingCar.getPosition()).isEqualTo(initialPos + 3);
    }
}