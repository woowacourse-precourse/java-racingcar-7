package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private List<Car> cars;
    private final Validator validator;
    private final Utils utils;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Validator validator, Utils utils, InputView inputView, OutputView outputView) {
        this.validator = validator;
        this.utils = utils;
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = new ArrayList<>();
    }

    private void inputAndValidateCars() {
        String carNamesInput = inputView.inputCarNames();

        validator.validateInputNotBlank(carNamesInput);
        validator.validateNoEmptyCarNames(carNamesInput);

        String[] carNames = utils.convertToCarNameArray(carNamesInput);

        validator.validateCarNameLength(carNames);
        utils.saveCarNamesToList(carNames, cars);
    }

    private int inputNumberOfAttempts() {
        return inputView.inputAttemptCount();
    }

    private void displayRacingResults() {
        for (Car car : cars) {
            utils.attemptCarMove(car);
        }
        outputView.printRaceResults(cars);
    }

    private void announceWinners() {
        List<String> winnerList = utils.getCarsWithHighestCount(cars);
        String name = utils.getWinnersAsString(winnerList);
        outputView.printWinners(name);
    }
}
