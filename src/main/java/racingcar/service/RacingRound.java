package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import racingcar.controller.domain.Car;
import racingcar.exception.Validator;

public class RacingRound {
    private List<Car> carList = new ArrayList<>();
    private HashMap<Car, Integer> carToRacingProgress = new HashMap<>();

    public RacingRound(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
            carToRacingProgress.put(car, 0);
        }
    }

    public void moveForward() {
        for (Car car : carList) {
            if (Validator.isFourOrMore(car.getRandomNumber())) {
                carToRacingProgress.put(car, carToRacingProgress.get(car) + 1);
            }
        }
    }

    public List<String> getWinner() {
        int maxValue = Integer.MIN_VALUE;
        for (int value : carToRacingProgress.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        List<String> maxKeys = new ArrayList<>();
        for (Entry<Car, Integer> entry : carToRacingProgress.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxKeys.add(entry.getKey().getName());
            }
        }
        return maxKeys;
    }

    public HashMap<Car, Integer> getCarToRacingProgress() {
        return carToRacingProgress;
    }
}
