package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    @Test
    void 우승자_판단_테스트() {
        RacingCar car1 = new RacingCar("Car1");
        RacingCar car2 = new RacingCar("Car2");
        RacingCar car3 = new RacingCar("Car3");

        RacingCarService racingCarService = new RacingCarService(List.of(car1, car2, car3), 1);

        assertRandomNumberInRangeTest(
            () -> {
                racingCarService.startRacing();
                assertThat(racingCarService.getWinners()).isEqualTo(List.of(car1, car3));
            },
            4, 3, 4
        );

    }


}