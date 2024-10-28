package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.util.InputFormatter;
import racingcar.util.MessageFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Cars cars = getCars();
        int count = getCount();
        printResultMessage();
        raceCars(cars, count);
        printWinners(cars);
    }

    private Cars getCars() {
        String carInput = getCarInput();
        List<String> beforeConvertCars = InputFormatter.getFormattedCarNames(carInput);
        return Cars.createCars(beforeConvertCars);
    }

    private int getCount() {
        String countInput = getCountInput();
        return InputFormatter.getFormattedCount(countInput);
    }

    private String getCarInput() {
        outputView.printCarInputMessage();
        return inputView.input();
    }

    private String getCountInput() {
        outputView.printCountInputMessage();
        return inputView.input();
    }

    private void raceCars(Cars cars, int count) {
        for (int i = 0; i < count; i++) {
            cars.race();
            printCarsInformation(cars.getCarsInformation());
        }
    }

    private void printResultMessage() {
        outputView.printMessage("");
        outputView.printResultHeader();
    }

    private void printCarsInformation(List<String> carsInformation) {
        carsInformation.forEach(outputView::printMessage);
        outputView.printMessage("");
    }

    private void printWinners(Cars cars) {
        List<String> winners = cars.determineWinners();
        String winnersName = MessageFormatter.getWinnersName(winners);
        outputView.printWinners(winnersName);
    }
}