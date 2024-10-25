package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
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

    @Test
    @DisplayName("전진 성공 시 전진 횟수는 +1, 아니라면 그대로")
    void 전진_테스트() {
        String name = "noname";
        RacingCar racingCar = new RacingCar(name);

        int notMoveForward = Randoms.pickNumberInRange(0, 3);
        racingCar.move(notMoveForward);
        assertEquals(racingCar.getForwardCount(), 0);

        int moveForWard = Randoms.pickNumberInRange(4, 9);
        racingCar.move(moveForWard);
        assertEquals(racingCar.getForwardCount(), 1);
    }
}