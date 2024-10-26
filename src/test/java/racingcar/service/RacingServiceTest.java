package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Record;
import racingcar.domain.race.Result;
import racingcar.domain.race.Results;

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
        final int roundCount = 5;

        //when
        final Results results = racingService.startRace(cars, roundCount);

        //then
        List<Result> raceResults = results.getResults();
        Result firstResult = raceResults.getFirst();
        List<Record> firstRecords = firstResult.getRecords();
        Record firstRecord = firstRecords.getFirst();

        assertThat(raceResults).hasSize(roundCount);
        assertThat(firstResult.getRound()).isEqualTo(1);
        assertThat(firstRecord.getCarName()).isEqualTo("a");
    }
}