package racingcar.racing.controller;

import static racingcar.racing.utils.ExceptionMessages.EMPTY_CAR_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INPUT_EMPTY_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INVALID_ATTEMPT_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INVALID_CAR_LENGTH_EXCEPTION_MESSAGE;

import java.util.List;
import racingcar.racing.model.Car;
import racingcar.racing.model.Game;
import racingcar.racing.model.RacingGameFactory;
import racingcar.racing.utils.InputParser;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class RacingGame {
    private final RacingGameFactory racingGameFactory;
    private Game game;

    public RacingGame(RacingGameFactory racingGameFactory) {
        this.racingGameFactory = racingGameFactory;
    }

    public void start() {
        List<String> carNames = inputCarNames();
        int attemptNumber = inputAttemptNumber();
        createRacingGame(carNames, attemptNumber);
        OutputView.printMessage("\n실행 결과");
        game.allRoundStart();
        List<Car> winners = game.selectWinners();
        OutputView.printWinner(winners);
    }

    private void createRacingGame(List<String> carNames, int attemptNumber) {
        List<Car> cars = racingGameFactory.createCars(carNames);
        this.game = racingGameFactory.createGame(attemptNumber, cars);
    }

    private int inputAttemptNumber() {
        OutputView.printMessage("시도할 횟수는 몇 회인가요?");
        String inputAttemptNumber = InputView.inputConsole();
        validateInputNotEmpty(inputAttemptNumber);
        int attemptNumber = parseAttemptNumber(inputAttemptNumber);
        validateAttemptNumber(attemptNumber);
        return attemptNumber;
    }

    private static void validateAttemptNumber(int attemptNumber) {
        if (!InputValidator.validateAttemptNumber(attemptNumber)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_EXCEPTION_MESSAGE);
        }
    }

    private int parseAttemptNumber(String inputAttemptNumber) {
        try {
            return Integer.parseInt(inputAttemptNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_EXCEPTION_MESSAGE);
        }
    }

    private List<String> inputCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = InputView.inputConsole();
        validateInputNotEmpty(inputCar);
        List<String> carNames = InputParser.parseCarNames(inputCar);
        validateCarNameLength(carNames);
        validateCarArrayNotEmpty(carNames);
        return carNames;
    }

    private static void validateCarArrayNotEmpty(List<String> carNames) {
        if (InputValidator.validateCarArrayNotEmpty(carNames)) {
            throw new IllegalArgumentException(EMPTY_CAR_EXCEPTION_MESSAGE);
        }
    }

    private void validateCarNameLength(List<String> carNames) {
        if (!InputValidator.validateCarNameLength(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateInputNotEmpty(String input) {
        if (InputValidator.validateInputNotEmpty(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
    }
}
