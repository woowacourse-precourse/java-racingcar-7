package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void 값이_4이상이면_전진한다(){
        RacingCar racingCar = new RacingCar("pobi");
        assertThat(racingCar.isForward(4)).isTrue();
        assertThat(racingCar.isForward(6)).isTrue();
        assertThat(racingCar.isForward(9)).isTrue();
        assertThat(racingCar.isForward(0)).isFalse();
        assertThat(racingCar.isForward(3)).isFalse();
    }

    @Test
    void 전진하면_위치가_1_늘어난다() {
        RacingCar racingCar = new RacingCar("pobi");
        int initialPos = racingCar.getPos();
        racingCar.moveForward(3);
        assertThat(racingCar.getPos()).isEqualTo(initialPos);

        racingCar.moveForward(4);
        assertThat(racingCar.getPos()).isEqualTo(initialPos + 1);
    }
}