package racingcar.application.service;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.RacingCar;

class WinnerIdentifierTest {

    private final WinnerIdentifier winnerIdentifier = new WinnerIdentifier();

    @DisplayName("가장 많이 이동한 자동차를 우승자로 선별한다.")
    @Test
    void identifyInOne() {
        Assertions.assertSimpleTest(() -> {
            RacingCar car1 = RacingCar.from("car1");
            RacingCar car2 = RacingCar.from("car2");

            car1.forward();
            car2.forward();
            car2.forward();

            List<RacingCar> racingCars = List.of(car1, car2);
            List<RacingCar> winners = winnerIdentifier.identify(racingCars);

            assertThat(winners).contains(car2);
        });
    }

    @DisplayName("우승자가 2명 이상일 경우도 있다.")
    @Test
    void identifyInTwoMore() {
        Assertions.assertSimpleTest(() -> {
            RacingCar car1 = RacingCar.from("car1");
            RacingCar car2 = RacingCar.from("car2");
            RacingCar car3 = RacingCar.from("car3");

            car1.forward();
            car1.forward();
            car2.forward();
            car2.forward();
            car3.forward();

            List<RacingCar> racingCars = List.of(car1, car2, car3);
            List<RacingCar> winners = winnerIdentifier.identify(racingCars);

            assertThat(winners).contains(car1, car2);
        });
    }
}
