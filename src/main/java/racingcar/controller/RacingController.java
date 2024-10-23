package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        String[] carNames = carInput.split(",");

        List<String> carNamesWithoutBlank = new ArrayList<>();
        for (String carName : carNames) {
            carNamesWithoutBlank.add(carName.trim());
        }

        return carNamesWithoutBlank;
    }

    private Cars convertToCars(List<String> stringCars) {
        List<Car> cars = new ArrayList<>();
        for (String stringCar : stringCars) {
            cars.add(new Car(stringCar));
        }
        return new Cars(cars);
    }

    private int convertToInt(String countInput) {
        return Integer.parseInt(countInput);
    }

    private void raceCars(Cars cars, int count) {
        outputView.printResultMessage();
        for (int i = 0; i < count; i++) {
             cars.race();
             printCarsInformation(cars.getCarsInformation());
        }
    }

    private void printCarsInformation(List<String> carsInformation) {
        for (String carInformation : carsInformation) {
            outputView.printCarInformation(carInformation);
        }
        outputView.printNewLine();
    }

    private void printWinners(Cars cars) {
        List<String> winners = cars.determineWinners();
        outputView.printWinners(winners);
    }
}
