package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("4를 기준으로 이상이면 true를, 미만이면 false 반환")
    void 이동_조건_테스트 () {

        assertThat(RacingCar.canMoveForward(0)).isFalse();
        assertThat(RacingCar.canMoveForward(3)).isFalse();
        assertThat(RacingCar.canMoveForward(4)).isTrue();
        assertThat(RacingCar.canMoveForward(9)).isTrue();
    }
}