package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.Validator;

public class RacingService {
    private final List<Car> carList = new ArrayList<>();
    private final LinkedHashMap<Car, Long> racingProgress = new LinkedHashMap<>();

    public RacingService(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
            racingProgress.put(car, 0L);
        }
    }

    public void moveForward() {
        for (Car car : carList) {
            car.setRandomNumber();

            if (Validator.isFourOrMore(car.getRandomNumber())) {
                racingProgress.put(car, racingProgress.get(car) + 1);
            }
        }
    }

    public List<String> getWinner() {
        long maxProgress = racingProgress.values()
                .stream()
                .max(Long::compare)
                .orElse(0L);

        return racingProgress.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxProgress)
                .map(entry -> entry.getKey().getName())
                .collect(Collectors.toList());
    }

    public LinkedHashMap<Car, Long> getRacingProgress() {
        return racingProgress;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
