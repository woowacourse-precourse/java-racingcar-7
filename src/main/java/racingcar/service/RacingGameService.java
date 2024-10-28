package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class RacingGameService {
    private final RacingCars racingCars;

    public RacingGameService(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars playRound() {
        racingCars.moveCars();
        return racingCars;
    }

    private int getMaxPosition() {
        return racingCars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
