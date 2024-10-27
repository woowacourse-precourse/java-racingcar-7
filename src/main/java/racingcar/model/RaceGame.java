package racingcar.model;

import java.util.List;
import racingcar.model.dto.RoundResultDto;

public class RaceGame {
    private final RaceCars raceCars;
    private final Movement movement;

    public RaceGame(RaceCars raceCars, Movement movement) {
        this.raceCars = raceCars;
        this.movement = movement;
    }

    public void moveAllCars() {
        raceCars.moveAllCars(movement);
    }

    public RoundResultDto getRoundResult() {
        List<Car> cars = raceCars.getCars();
        return new RoundResultDto(cars.stream().map(Car::toString).toList());
    }

    public RaceCars getRaceCars() {
        return raceCars;
    }
}
