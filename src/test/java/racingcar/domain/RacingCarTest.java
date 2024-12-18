package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void 레이싱카가_정상적으로_생성된다() {
        String carName = "star1";
        RacingCar racingCar = new RacingCar(carName);
        assertEquals(carName, racingCar.getCarName(), "레이싱 카 이름이 일치하지 않습니다.");
        assertEquals(0, racingCar.getAdvanceCount(), "초기 전진 횟수는 0이어야 합니다.");
    }

    @Test
    void 레이싱카는_정상적으로_전진한다() {
        final int MOVING_FORWARD = 7;

        assertRandomNumberInRangeTest(
                () -> {
                    RacingCar car = new RacingCar("a0814");
                    car.tryToAdvance();
                    assertThat(car.getAdvanceCount()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 레이싱카는_정상적으로_전진하지_못한다() {
        final int STOP = 1;

        assertRandomNumberInRangeTest(
                () -> {
                    RacingCar car = new RacingCar("won");
                    car.tryToAdvance();
                    assertThat(car.getAdvanceCount()).isEqualTo(0);
                },
                STOP
        );
    }
}