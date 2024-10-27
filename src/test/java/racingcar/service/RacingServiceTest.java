package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Result;
import racingcar.domain.race.RoundCount;

class RacingServiceTest {

    private final RacingService racingService = new RacingService();

    @Test
    @DisplayName("자동차 경주 진행")
    void startRace() {
        //given
        final List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        final CarNames carNames = new CarNames(names);
        final Cars cars = Cars.from(carNames);
        final RoundCount roundCount = RoundCount.from("5");

        //when
        final Result result = racingService.startRace(cars, roundCount);

        //then
        assertThat(result.getResults()).hasSize(5);
    }
}