package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.controller.domain.Car;
import racingcar.exception.Validator;

public class RacingService {
    private long tryNumber;
    private List<Car> carList = new ArrayList<>();
    private HashMap<Car, Integer> carToRacingProgress = new HashMap<>();

    public RacingService(List<String> carNameList, long tryNumber) {
        this.tryNumber = tryNumber;

        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
            carToRacingProgress.put(car, 0);
        }
    }

    public void start() {
        while (tryNumber > 0) {
            tryNumber--;
            moveForward();
        }
    }

    private void moveForward() {
        for (Car car : carList) {
            if (Validator.isFourOrMore(car.getRandomNumber())) {
                carToRacingProgress.put(car, carToRacingProgress.get(car) + 1);
            }
        }
    }

    public HashMap<Car, Integer> getCarToRacingProgress() {
        return carToRacingProgress;
    }
}
