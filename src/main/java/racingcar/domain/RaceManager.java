package racingcar.domain;

import racingcar.dto.InputDto;
import racingcar.views.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private final RacingCars racingCars;
    private final Attempts attempts;
    private int winningPosition;
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
        showWinners();
    }

    private void showWinners() {
        OutputView.printWinner(winnersName);
    }

    private void showResultPerAttempt() {
        OutputView.printResultPerAttempts(racingCars.getCars());
    }

    private void findWinningPosition() {
        winningPosition =  racingCars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void findWinningCarsNames() {
        winnersName = racingCars.getCars()
                .stream()
                .filter(car -> car.getPosition() == winningPosition) // == 연산으로 비교
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
