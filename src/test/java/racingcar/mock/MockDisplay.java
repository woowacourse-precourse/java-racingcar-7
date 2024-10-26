package racingcar.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;
import racingcar.domain.game.Display;
import racingcar.io.DisplayImpl;

public class MockDisplay implements Display {

    private List<Car> winners;
    private Map<Car, Integer> positionMap = new HashMap<>();

    public MockDisplay(List<Car> cars) {
        cars.forEach(car -> positionMap.put(car, 0));
    }

    @Override
    public void progress(List<Car> cars) {
        cars.forEach(car -> positionMap.put(car, car.getPosition()));
    }

    @Override
    public void winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public Map<Car, Integer> getPositionMap() {
        return positionMap;
    }
}
