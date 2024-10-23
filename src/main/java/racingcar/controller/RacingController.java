package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        String carInput = getCarInput();
        String countInput = getCountInput();

        List<Car> cars = getCars(carInput);
        int count = convertStringCountToInt(countInput);

        outputView.printResultMessage();

        for (int i = 0; i < count; i++) {
            raceCars(cars);
            printCarsStatus(cars);
        }


    }

    private String getCarInput() {
        outputView.printCarInputMessage();
        return inputView.input();
    }

    private String getCountInput() {
        outputView.printCountInputMessage();
        return inputView.input();
    }

    private List<Car> getCars(String carInput) {
        List<String> stringCars = splitCar(carInput);
        return convertStringCarsToCars(stringCars);
    }

    private List<String> splitCar(String carInput) {
        return new ArrayList<String>(Arrays.asList(carInput.split(",")));
    }

    private List<Car> convertStringCarsToCars(List<String> stringCars) {
        List<Car> cars = new ArrayList<>();
        for (String stringCar : stringCars) {
            cars.add(new Car(stringCar));
        }
        return cars;
    }

    private int convertStringCountToInt(String countInput) {
        return Integer.parseInt(countInput);
    }

    private void raceCars(List<Car> cars) {
        for (Car car : cars) {
            car.race();
        }
    }

    private void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCarStatus(car.getName(), car.getStatus());
        }
        outputView.printNewLine();
    }
}
