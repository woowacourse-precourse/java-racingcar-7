package racingcar.config;

import racingcar.domain.RaceProgressManager;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.WinnerDecider;
import racingcar.domain.MovementPolicy;
import racingcar.dto.MovementNumber;

import java.util.List;
import java.util.stream.Collectors;

public class RaceSetupFacade {

    public List<RacingCar> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public RaceProgressManager createRaceProgressManager(List<RacingCar> cars) {
        return new RaceProgressManager(cars);
    }

    public RandomNumberGenerator createRandomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public WinnerDecider createWinnerDecider() {
        return new WinnerDecider();
    }

    public MovementPolicy createMovementPolicy(MovementNumber movementNumber) {
        return new MovementPolicy(movementNumber);
    }
}
