package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars;
    private final int round;

    public RacingGame(List<Car> cars, int round) {
        this.racingCars = cars;
        this.round = round;
    }
    
    public List<CarStatusDto> getCurrentRoundStatus() {
        return racingCars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }
}
