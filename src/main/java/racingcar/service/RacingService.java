package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.Validator;

public class RacingService {
    private final List<Car> carList = new ArrayList<>();
    private final HashMap<Car, Long> carToRacingProgress = new HashMap<>();

    public RacingService(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
            carToRacingProgress.put(car, 0L);
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
        long maxValue = carToRacingProgress.values()
                .stream()
                .max(Long::compare)
                .orElse(Long.MIN_VALUE);

        return carToRacingProgress.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(entry -> entry.getKey().name())
                .collect(Collectors.toList());
    }

    public HashMap<Car, Long> getCarToRacingProgress() {
        return carToRacingProgress;
    }
}
