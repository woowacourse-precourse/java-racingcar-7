package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void 전진하면_위치가_1_늘어난다() {
        RacingCar racingCar = new RacingCar("pobi");
        int initialPos = racingCar.getPos();

        racingCar.moveForward(() -> 0);
        assertThat(racingCar.getPos()).isEqualTo(initialPos);

        racingCar.moveForward(() -> 3);
        assertThat(racingCar.getPos()).isEqualTo(initialPos);

        racingCar.moveForward(() -> 4);
        assertThat(racingCar.getPos()).isEqualTo(initialPos + 1);

        racingCar.moveForward(() -> 6);
        assertThat(racingCar.getPos()).isEqualTo(initialPos + 2);

        racingCar.moveForward(() -> 9);
        assertThat(racingCar.getPos()).isEqualTo(initialPos + 3);
    }

    @Test
    void 자동차의_이름은_5자_이하만_가능하다() {
        new RacingCar("abcde");
        new RacingCar("abcd ");

        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");

        assertThatThrownBy(() -> new RacingCar("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 [1,5] 이내여야 합니다.");
    }
}