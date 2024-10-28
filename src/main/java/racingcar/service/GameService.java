package racingcar.service;

import racingcar.model.CarsManager;
import racingcar.dto.RacingResult;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    public void moveAllCarsOnce(CarsManager cars) {
        cars.move();
    }

    public List<RacingResult> convertToRacingResults(CarsManager cars) {
        return cars.getCars().stream()
                .map(car -> new RacingResult(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }
}