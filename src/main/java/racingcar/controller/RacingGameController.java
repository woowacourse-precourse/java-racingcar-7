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
import java.util.Set;

public class RacingGameController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final CarFactory carFactory;
    private final RacingGameService racingGameService;
    private final OutputView outputView;

    public RacingGameController(InputView inputView,
                                InputValidator inputValidator,
                                CarFactory carFactory,
                                RacingGameService racingGameService, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.carFactory = carFactory;
        this.racingGameService = racingGameService;
        this.outputView = outputView;
    }

    public void run() {
        Set<Car> cars = initializeCars();
        int round = getRound();
        startRaceAndPrintCarsPosition(round, cars);
        List<String> winner = racingGameService.getWinner(cars);
        printWinner(winner);
    }

    private Set<Car> initializeCars() {
        String[] carNames = Separator.splitWithComma(inputView.getCarNames());
        inputValidator.validateCarNamesAndNumberOfCars(carNames);
        return carFactory.createCars(carNames);
    }

    private void startRaceAndPrintCarsPosition(int round, Set<Car> cars) {
        outputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGameService.moveCars(cars);
            outputView.printCarsPosition(cars);
        }
    }

    private void printWinner(List<String> winner) {
        String winnerStr = convertWinnerToString(winner);
        outputView.printWinner(winnerStr);
    }

    private String convertWinnerToString(List<String> winner) {
        if (isMultiWinner(winner)) {
            return Joiner.join(",", winner);
        }
        return winner.get(0);
    }

    private boolean isMultiWinner(List<String> winner) {
        return winner.size() > 1;
    }

    private int getRound() {
        return inputValidator.validateAttemptCount(inputView.getGameAttempt());
    }
}
