package racingcar.service.race;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.service.prep.RacePrepService;

class LapUpdateServiceTest {

    private LapUpdateService lapUpdateService;
    private Long lapCount = 5L;

    private Registration registration() {
        List<String> lineup = List.of("test1", "test2");
        return new Registration(lineup, lapCount);
    }

    private Race testRace() {
        RacePrepService racePrepService = new RacePrepService();
        return racePrepService.prepare(registration());
    }

    @Test
    @DisplayName("lap 완료 후 Race 상태 변화")
    void status () {
        Race race = testRace();
        lapUpdateService = new LapUpdateService(race);

        lapUpdateService.runLap();
        Long expected = lapCount - 1L;

        assertEquals(expected, race.getLapLefts());
    }

    @Test
    @DisplayName("모든 자동차들이 움직였는지 (기름 소모)")
    void oilConsumption () {
        Race race = testRace();
        lapUpdateService = new LapUpdateService(race);

        List<Long> before = race.getEntry().stream().map(Car::oilStatus).toList();
        lapUpdateService.runLap();

        List<Long> after = race.getEntry().stream().map(Car::oilStatus).toList();
        List<Long> expected = before.stream().map(oil -> (oil - 1L)).toList();

        assertEquals(expected, after);
    }
}