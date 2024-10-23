package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Round {
    private final LinkedHashMap<String, Integer> state;

    public Round(LinkedHashMap<String, Integer> state) {
        this.state = state;
    }

    public LinkedHashMap<String, Integer> getState() {
        return state;
    }

    public static Round of(List<Car> carList) {
        LinkedHashMap<String, Integer> state = new LinkedHashMap<>();

        carList.forEach(car -> {
            state.put(car.getName(), car.getPosition());
        });

        return new Round(state);
    }
}
