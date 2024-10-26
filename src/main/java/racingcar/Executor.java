package racingcar;

import java.util.List;

public class Executor {
    private List<Car> cars;
    private final String operator = ",";

    private IOController ioController;
    private Parser parser;
    private Validator validator;


    Executor(IOController ioController, Parser parser, Validator validator) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
    }

    private void saveCarsByName(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void executeForCount(List<Car> cars, long repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            executeForAllCars(cars);
            ioController.printResults(cars);
        }
    }

    private void executeForAllCars(List<Car> cars) {
        for (Car car : cars) {
            int randomVal = Randoms.pickNumberInRange(0, 9);
            if (moveLimit <= randomVal) {
                car.move();
            }
        }
    }
}
