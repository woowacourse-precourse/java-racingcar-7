package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    private long repeatCount;
    private final String operator = ",";
    private final int nameLengthLimit = 5;
    private final int moveStandard = 4;

    private List<Car> cars;
    private List<Car> winners;

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
