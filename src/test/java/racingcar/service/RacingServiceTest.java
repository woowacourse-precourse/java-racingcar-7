package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Result;

class RacingServiceTest {

    private final RacingService racingService = new RacingService();

    @Test
    @DisplayName("자동차 경주 진행")
    void startRace() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        int roundCount = 5;

        //when
        List<Result> results = racingService.startRace(cars, roundCount);

        //then
        assertThat(results).hasSize(roundCount);
        assertThat(results.getFirst().getRound()).isEqualTo(1);
        assertThat(results.getFirst().getRecords().getFirst().getCarName()).isEqualTo("a");
    }
}