package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::create)
                .toList();
    }

    public static Cars apply(List<String> carNames) {
        return new Cars(carNames);
    }

    public void playRound() {
        for (Car car : cars) {
            if (car.pickRandomNumber() >= 4) {
                car.moveForward();
            }
        }
    }

    public List<String> findWinner() {
        return cars.stream()
                .filter(car -> car.getLocation() == findWinnerLocation())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getCarStatus() {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            map.put(car.getName(), car.getLocation());
        }
        return map;
    }

    private int findWinnerLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
