package racingcar.racingGame;

import racingcar.car.Car;
import racingcar.validation.AttemptValidation;
import racingcar.validation.CarNameValidation;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame extends RacingGameTemplate {

    private final RacingGameData data = new RacingGameData();

    public RacingGame() {
    }

    @Override
    protected void initializeGame() {
        List<String> carNames = Arrays.stream(InputView.inputCarNames().split(",")).toList();
        CarNameValidation.validate(carNames);
        String inputAttempts = InputView.inputRaceAttempts();
        AttemptValidation.validate(inputAttempts);
        data.initialize(carNames, new BigInteger(inputAttempts));
    }

    @Override
    protected void race() {
        BigInteger attemptCount = BigInteger.ZERO;
        racingPerAttempt(attemptCount);
    }

    @Override
    protected void announceWinners() {
        BigInteger winningPosition = getWinningPosition();
        List<String> winnersNames = getWinnersName(winningPosition);
        OutputView.printWinner(winnersNames);
    }

    private void racingPerAttempt(BigInteger attemptCount) {
        while (attemptCount.compareTo(data.getAttempts()) < 0) {
            moveOrStop();
            attemptCount = attemptCount.add(BigInteger.ONE);
            OutputView.printResultPerAttempts(data.getCars());
        }
    }

    private List<String> getWinnersName(BigInteger winningPosition) {
        return data.getCars()
                .stream()
                .filter(car -> car.getPosition().compareTo(winningPosition) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private BigInteger getWinningPosition() {
        return data.getCars()
                .stream()
                .map(Car::getPosition)
                .max(BigInteger::compareTo)
                .orElse(BigInteger.ZERO);
    }

    private void moveOrStop() {
        data.getCars()
                .forEach(Car::moveOrStop);
    }
}
