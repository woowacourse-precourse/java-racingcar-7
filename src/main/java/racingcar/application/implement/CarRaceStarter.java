package racingcar.application.implement;

import java.util.List;
import racingcar.domain.CarRacer;

public class CarRaceStarter implements RaceStarter<CarRacer> {

    private final MovementStrategy movementStrategy;

    public CarRaceStarter(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void start(List<CarRacer> carRacers) {
        carRacers.forEach(racingCar -> {
            if (movementStrategy.isMovable()) {
                racingCar.forward();
            }
        });
    }
}
