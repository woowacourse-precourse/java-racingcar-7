package racingcar.domain;

import racingcar.views.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private final RacingCars racingCars;
    private final Attempts attempts;
    private BigInteger winningPosition;
    private List<String> winnersName;

    private RaceManager(RacingCars racingCars, Attempts attempts) {
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

    public void findWinningPosition() {
        winningPosition =  racingCars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(BigInteger::compareTo)
                .orElse(BigInteger.ZERO);
    }

    public void findWinningCarsNames() {
        winnersName = racingCars.getCars()
                .stream()
                .filter(car -> car.getPosition().compareTo(winningPosition) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveOrStop() {
        racingCars.getCars()
                .forEach(Car::move);
    }

    public void announceRaceResult(){
        OutputView.printWinner(winnersName);
    }

    public static RaceManager createRaceManager(RacingCars racingCars, Attempts attempts) {
        return new RaceManager(racingCars, attempts);
    }
}
