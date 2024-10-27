package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.FinalResultDto;
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
        return RoundResultDto.of(cars.stream().collect(Collectors.toMap(Car::getName, Car::getPosition)));
    }

    public FinalResultDto getWinner() {
        int maxPosition = raceCars.getMaximumPosition();
        List<String> winners = raceCars.getWinners(maxPosition);
        return new FinalResultDto(winners);

    }

    public RaceCars getRaceCars() {
        return raceCars;
    }
}
