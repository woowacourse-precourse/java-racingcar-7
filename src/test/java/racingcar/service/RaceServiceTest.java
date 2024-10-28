package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.AlwaysMoveStrategy;
import racingcar.model.car.Car;

public class RaceServiceTest {
    @Test
    @DisplayName("경주가 올바르게 초기화된다")
    void shouldInitializeRaceCorrectly() {
        RaceService raceService = new RaceService();
        raceService.initializeRace(
                new String[]{"Car1", "Car2"},
                new AlwaysMoveStrategy(),
                5
        );
        List<Car> cars = raceService.getCars();
        assertFalse(cars.isEmpty());
    }

    @Test
    @DisplayName("경주에서 자동차들이 이동한다")
    void shouldMoveCarsInRace() {
        RaceService raceService = new RaceService();
        raceService.initializeRace(
                new String[]{"Car1"},
                new AlwaysMoveStrategy(),
                3
        );
        raceService.moveCars();
    }

    @Test
    @DisplayName("경주 종료 후 올바른 우승자를 반환한다")
    void shouldGetCorrectWinnersAfterRace() {
        RaceService raceService = new RaceService();
        raceService.initializeRace(
                new String[]{"Car1", "Car2"},
                new AlwaysMoveStrategy(),
                1
        );
        raceService.moveCars();
        List<String> winners = raceService.getWinners();
        assertFalse(winners.isEmpty());
    }
}
