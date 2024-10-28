package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingGame {
    public RacingGame(List<String> carNames, int maxRound) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.maxRound = maxRound;
    }

    public HashMap<String, Integer> getState() {
        HashMap<String, Integer> state = new HashMap<>();
        for (Car car : cars) {
            state.put(car.getName(), car.getPosition());
        }
        return state;
    }

    private final List<Car> cars = new ArrayList<>();
    private final int maxRound;
}
