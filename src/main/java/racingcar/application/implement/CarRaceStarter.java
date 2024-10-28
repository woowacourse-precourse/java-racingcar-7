package racingcar.application.implement;

import static racingcar.common.constant.RacingCarConstant.MAX_RANDOM_BOUND;
import static racingcar.common.constant.RacingCarConstant.MIN_RANDOM_BOUND;
import static racingcar.common.constant.RacingCarConstant.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
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
