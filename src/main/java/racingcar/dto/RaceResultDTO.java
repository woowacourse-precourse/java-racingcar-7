package racingcar.dto;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

public class RaceResultDTO {

    private final List<Race> races;
    private final List<Car> raceWinners;

    public RaceResultDTO(List<Race> races, List<Car> raceWinners) {
        this.races = races;
        this.raceWinners = raceWinners;
    }

    public List<Car> getRaceWinners() {
        return raceWinners;
    }

    public List<Race> getRaces() {
        return races;
    }
}
