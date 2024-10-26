package racingcar.controller;


import static racingcar.exception.ExceptionMessage.INVALID_INPUT_NUMBER;
import static racingcar.exception.ExceptionMessage.MINIMUM_RACING_TIME;
import static racingcar.exception.ExceptionMessage.USER_INPUT_NOT_NULL;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.Racing;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static final String CHECK_NUMBER_REGEX = "\\d+";

    private Racing racing;
    private CarManager carManager;
    private OutputView outputView;
    private RandomNumber randomNumber = new RandomNumber();

    public RacingController(Racing racing, CarManager carManager,
            OutputView outputView) {
        this.racing = racing;
        this.carManager = carManager;
        this.outputView = outputView;
    }

    public void start() {
        String userInput = InputView.getInputCarString();
        verifyUserInput(userInput);
        carManager.setupCarsFromUserInput(userInput);
        executeRaceRounds();
        announceWinner();
    }

    private void executeRaceRounds() {
        String userInput = InputView.getInputRepeatCount();
        verifyRepeatCount(userInput);
        int cnt = Integer.parseInt(userInput);
        outputView.printGameResultMessage();
        for (int i = 0; i < cnt; i++) {
            runSingleRound();
            outputView.printEmptyLine();
        }
    }

    private void announceWinner() {
        String winner = racing.findWinner(carManager.getCars());
        outputView.printWinner(winner);
    }

    private void runSingleRound() {
        List<Car> cars = carManager.startRacing(randomNumber);
        for (Car car : cars) {
            outputView.printGameResult(car.getName(), car.getMovedDistance());
        }
    }

    private void verifyRepeatCount(String userInput) {
        if (!userInput.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
        if (Integer.parseInt(userInput) == 0) {
            throw new IllegalArgumentException(MINIMUM_RACING_TIME.getMessage());
        }
    }

    private void verifyUserInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(USER_INPUT_NOT_NULL.getMessage());
        }
    }

}
