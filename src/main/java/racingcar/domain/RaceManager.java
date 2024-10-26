package racingcar.domain;

import racingcar.dto.InputDto;
import racingcar.utils.moving.MovingStrategy;
import racingcar.utils.moving.MovingByRandomNumber;
import racingcar.views.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private final RacingCars racingCars;
    private final Attempts attempts;
    private final MovingStrategy movingStrategy;
    private int winningPosition;
    private List<String> winnersName;

    private RaceManager(RacingCars racingCars, Attempts attempts, MovingStrategy movingStrategy) {
        this.racingCars = racingCars;
        this.attempts = attempts;
        this.movingStrategy = movingStrategy;
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
                .mapToInt(Car::getPositionDistance)
                .max()
                .orElse(0);
    }

    private void findWinningCarsNames() {
        winnersName = racingCars.getCars()
                .stream()
                .filter(car -> car.getPositionDistance() == winningPosition) // == 연산으로 비교
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void moveOrStop() {
        racingCars.getCars()
                .forEach(car -> car.move(movingStrategy));
    }

    public static RaceManager createRaceManager(InputDto dto,
                                                MovingStrategy movingStrategy) {
        return new RaceManager(
                RacingCars.from(dto.inputCarNames()),
                Attempts.from(dto.inputAttempts()),
                movingStrategy
        );
    }
}
