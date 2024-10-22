package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.Generator;

public class Cars {

    public static final int START_POSITION = 0;
    private List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
            .map(carName -> new Car(carName, START_POSITION))
            .toList();
    }

    public void playRound(Generator generator) {
        for (Car car : cars) {
            int randomNum = generator.generate();
            car.go(randomNum);
        }
    }

    public Map<String, Integer> getRoundResult() {
        LinkedHashMap<String, Integer> roundResult = new LinkedHashMap<>();
        cars.stream()
            .forEach(car -> roundResult.put(car.getName(), car.getPosition()));
        return roundResult;
    }

    public List<String> getFinalResult() {
        int maxPosition = findMaxPosition();
        return findWinnersName(maxPosition);
    }

    private List<String> findWinnersName(int max) {
        return cars.stream()
            .filter(car -> car.getPosition() == max)
            .map(car -> car.getName())
            .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(car -> car.getPosition())
            .max()
            .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}
