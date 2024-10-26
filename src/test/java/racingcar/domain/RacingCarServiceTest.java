package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    @Test
    void 우승자_판단_테스트(){
        RacingCar car1 = new RacingCar("Car1");
        car1.moveForward();
        car1.moveForward();

        RacingCar car2 = new RacingCar("Car2");
        car2.moveForward();

        RacingCar car3 = new RacingCar("Car3");
        car3.moveForward();
        car3.moveForward();

        RacingCarService racingCarService = new RacingCarService(List.of(car1,car2,car3),0);
        racingCarService.findWinners();

        assertThat(racingCarService.getWinners()).isEqualTo(List.of(car1,car3));
    }


}