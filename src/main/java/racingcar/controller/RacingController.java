package racingcar.controller;


import static racingcar.exception.ExceptionMessage.INVALID_INPUT_NUMBER;

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

    public RacingController(Racing racing, CarManager carManager,
            OutputView outputView) {
        this.racing = racing;
        this.carManager = carManager;
        this.outputView = outputView;
    }

    public void start() {
        carManager.setupCarsFromUserInput(InputView.getInputCarString());
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
        List<Car> cars = carManager.startRacing(RandomNumber.generate());
        for (Car car : cars) {
            outputView.printGameResult(car.getName(), car.getMovedDistance());
        }
    }

    private void verifyRepeatCount(String userInput) {
        if (!userInput.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }

}
