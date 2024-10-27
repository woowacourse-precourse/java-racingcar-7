package racingcar.controller;

import racingcar.common.InputValidator;
import racingcar.service.RacingGameService;
import racingcar.util.Joiner;
import racingcar.util.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Car;
import racingcar.vo.CarFactory;

import java.util.List;

public class RacingGameController {

    private final InputValidator inputValidator;
    private final CarFactory carFactory;
    private final RacingGameService racingGameService;

    public RacingGameController(InputValidator inputValidator,
                                CarFactory carFactory,
                                RacingGameService racingGameService) {
        this.inputValidator = inputValidator;
        this.carFactory = carFactory;
        this.racingGameService = racingGameService;
    }

    public void run() {
        List<Car> cars = initializeCars();
        int rounds = getValidateRounds();
        playRounds(rounds, cars);
        printWinner(racingGameService.getWinner(cars));
    }

    private List<Car> initializeCars() {
        String[] carNames = Separator.splitWithComma(InputView.getCarNames());
        inputValidator.validateCarNamesAndNumberOfCars(carNames);
        return carFactory.createCars(carNames);
    }

    private void playRounds(int rounds, List<Car> cars) {
        OutputView.printResultMessage();
        for (int i = 0; i < rounds; i++) {
            racingGameService.moveCars(cars);
            OutputView.printCarsPosition(cars);
        }
    }

    private void printWinner(List<String> winner) {
        String winnerStr = convertWinnerToString(winner);
        OutputView.printWinner(winnerStr);
    }

    private String convertWinnerToString(List<String> winner) {
        return Joiner.join(",", winner);
    }

    private int getValidateRounds() {
        return inputValidator.validateAttemptCount(InputView.getGameAttempt());
    }
}
