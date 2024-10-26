package racingcar.domain;

import racingcar.dto.InputDto;
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
            showResultPerAttempt();
        }
    }

    public void announceRaceResult(){
        findWinningPosition();
        findWinningCarsNames();
        OutputView.printWinner(winnersName);
    }

    private void showResultPerAttempt() {
        OutputView.printResultPerAttempts(racingCars.getCars());
    }

    private void findWinningPosition() {
        winningPosition =  racingCars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(BigInteger::compareTo)
                .orElse(BigInteger.ZERO);
    }

    private void findWinningCarsNames() {
        winnersName = racingCars.getCars()
                .stream()
                .filter(car -> car.getPosition().compareTo(winningPosition) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void moveOrStop() {
        racingCars.getCars()
                .forEach(Car::move);
    }

    public static RaceManager createRaceManager(InputDto dto) {
        return new RaceManager(
                RacingCars.from(dto.inputCarNames()),
                Attempts.from(dto.inputAttempts())
        );
    }
}
