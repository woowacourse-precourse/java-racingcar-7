package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final List<Car> cars;
    private final int trial;
    private List<Map<String, Integer>> allResult = new ArrayList<>();

    public RacingGame(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
        moveCarsByTrial();
    }

    private void moveCarsByTrial() {
        for (int i = 0; i < trial; i++) {
            allResult.add(moveCars());
        }
    }

    private Map<String, Integer> moveCars() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();

        for (Car car : cars) {
            car.move();
            roundResult.put(car.getName(), car.getPosition());
        }
        return roundResult;
    }

    public List<Map<String, Integer>> getAllResult() {
        return allResult;
    }

    public List<Car> getCars() {
        return cars;
    }
}
