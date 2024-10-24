package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final static String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;

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
        List<String> carsBeforeConvert = splitCar(carInput);
        InputValidator.validateCarNames(carsBeforeConvert);
        Cars cars = convertToCars(carsBeforeConvert);
        return cars;
    }

    private int getCount() {
        String countInput = getCountInput();
        InputValidator.validateCount(countInput);
        int count = convertToInt(countInput);
        return count;
    }

    private String getCarInput() {
        outputView.printCarInputMessage();
        return inputView.input();
    }

    private String getCountInput() {
        outputView.printCountInputMessage();
        return inputView.input();
    }

    private List<String> splitCar(String carInput) {
        String[] carNames = carInput.split(CAR_NAME_DELIMITER);
        return Arrays.stream(carNames).map(String::trim).toList();
    }

    private Cars convertToCars(List<String> stringCars) {
        List<Car> cars = stringCars.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    private int convertToInt(String countInput) {
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
        String winnersName = getWinnersName(winners);
        outputView.printWinners(winnersName);
    }

    private String getWinnersName(List<String> winners) {
        StringBuilder winnersString = new StringBuilder();
        winners.forEach(winner -> {
            winnersString.append(winner).append(", ");
        });
        return winnersString.substring(0, winnersString.length() - 2);
    }
}