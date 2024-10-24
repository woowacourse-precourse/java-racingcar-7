package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.MessageFormatter;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final static String DELIMITER = ",";

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Cars cars = getCars();
        int count = getCount();
        raceCars(cars, count);
        printWinners(cars);
    }

    private Cars getCars() {
        String carInput = getCarInput();
        List<String> beforeConvertCars = splitInput(carInput);
        InputValidator.validateCarNames(beforeConvertCars);
        return convertToCars(beforeConvertCars);
    }

    private int getCount() {
        String countInput = getCountInput();
        return getFormattedCount(countInput);
    }

    private String getCarInput() {
        outputView.printCarInputMessage();
        return inputView.input();
    }

    private String getCountInput() {
        outputView.printCountInputMessage();
        return inputView.input();
    }

    private List<String> splitInput(String carInput) {
        String[] carNames = carInput.split(DELIMITER);
        return Arrays.stream(carNames).map(String::trim).toList();
    }

    private Cars convertToCars(List<String> stringCars) {
        List<Car> cars = stringCars.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    public static int getFormattedCount(String countInput) {
        InputValidator.validateCount(countInput);
        return convertToInt(countInput);
    }

    private static int convertToInt(String countInput) {
        return Integer.parseInt(countInput);
    }

    private void raceCars(Cars cars, int count) {
        outputView.printMessage("");
        outputView.printResultMessage();
        for (int i = 0; i < count; i++) {
            cars.race();
            printCarsInformation(cars.getCarsInformation());
        }
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