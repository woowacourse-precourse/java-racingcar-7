package racingcar.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceHistory {
    private final List<Map<String, Integer>> history;

    public RaceHistory() {
        this.history = new ArrayList<>();
    }

    public void addRound(List<Car> cars) {
        Map<String, Integer> roundState = new HashMap<>();
        cars.forEach(car -> roundState.put(car.getName(), car.getPosition()));
        this.history.add(roundState);
    }

    public Map<String, Integer> getRound(int index) {
        return this.history.get(index);
    }

    public List<Map<String, Integer>> getRounds() {
        return this.history;
    }

    public Map<String, Integer> getLastRound() {
        return this.history.getLast();
    }
}
