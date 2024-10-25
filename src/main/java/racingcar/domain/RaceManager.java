package racingcar.domain;

import racingcar.views.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private final RacingCars racingCars;
    private final Attempts attempts;

    public RaceManager(RacingCars racingCars, Attempts attempts) {
        this.racingCars = racingCars;
        this.attempts = attempts;
    }

    public void racePerAttempt() {
        while (attempts.isLeft()) {
            moveOrStop();
            attempts.decrease();
            OutputView.printResultPerAttempts(racingCars.getCars());
        }
    }

    public BigInteger findWinningPosition() {
        return racingCars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(BigInteger::compareTo)
                .orElse(BigInteger.ZERO);
    }

    public List<String> findWinningCarsNames(BigInteger winningPosition) {
        return racingCars.getCars()
                .stream()
                .filter(car -> car.getPosition().compareTo(winningPosition) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveOrStop() {
        racingCars.getCars()
                .forEach(Car::move);
    }

    public static RaceManager createRaceManager(RacingCars racingCars, Attempts attempts) {
        return new RaceManager(racingCars, attempts);
    }
}
