package io;

import car.Car;
import org.junit.jupiter.api.Test;
import racingcar.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarOutputHandlerTest {

    private RacingCarOutputHandler racingCarOutputHandler = new RacingCarOutputHandler();
    private RacingCar racingCar = new RacingCar();

    @Test
    void 최종_우승자_검증() {
        // given
        Car car1 = Car.of("poni");
        int randomResult1 = 4;
        racingCar.carMove(car1, randomResult1);

        Car car2 = Car.of("woni");
        int randomResult2 = 7;
        racingCar.carMove(car2, randomResult2);

        Car car3 = Car.of("jun");
        int randomResult3 = 2;
        racingCar.carMove(car3, randomResult3);

        // when
        String stringWinnerList = racingCarOutputHandler.displayFinalResult(List.of(car1, car2, car3));

        // then
        assertThat(stringWinnerList).isEqualTo("poni, woni");
    }
}