package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("4이상의 점수에만 전진한다.")
    @Test
    void 전진_성공_테스트() {
        RacingCar racingCar = new RacingCar("aaaaa");
        int prevForwardCount = racingCar.getForwardCount();
        racingCar.forwardCar(4);
        Assertions.assertThat(racingCar.getForwardCount()).isEqualTo(prevForwardCount + 1);
    }

    @DisplayName("4미만의 점수에는 전진하지 않는다.")
    @Test
    void 전진_실패_테스트() {
        RacingCar racingCar = new RacingCar("aaaaa");
        int prevForwardCount = racingCar.getForwardCount();
        racingCar.forwardCar(3);
        Assertions.assertThat(racingCar.getForwardCount()).isEqualTo(prevForwardCount);
    }
}
