package racingcar.application.service;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.implement.RacingWinnerIdentifier;
import racingcar.domain.CarRacer;

class RacingWinnerIdentifierTest {

    private final RacingWinnerIdentifier racingWinnerIdentifier = new RacingWinnerIdentifier();

    @DisplayName("가장 많이 이동한 자동차를 우승자로 선별한다.")
    @Test
    void identifyInOne() {
        Assertions.assertSimpleTest(() -> {
            CarRacer car1 = CarRacer.from("car1");
            CarRacer car2 = CarRacer.from("car2");

            car1.forward();
            car2.forward();
            car2.forward();

            List<CarRacer> carRacers = List.of(car1, car2);
            List<CarRacer> winners = racingWinnerIdentifier.identify(carRacers);

            assertThat(winners).contains(car2);
        });
    }

    @DisplayName("우승자가 2명 이상일 경우도 있다.")
    @Test
    void identifyInTwoMore() {
        Assertions.assertSimpleTest(() -> {
            CarRacer car1 = CarRacer.from("car1");
            CarRacer car2 = CarRacer.from("car2");
            CarRacer car3 = CarRacer.from("car3");

            car1.forward();
            car1.forward();
            car2.forward();
            car2.forward();
            car3.forward();

            List<CarRacer> carRacers = List.of(car1, car2, car3);
            List<CarRacer> winners = racingWinnerIdentifier.identify(carRacers);

            assertThat(winners).contains(car1, car2);
        });
    }
}
