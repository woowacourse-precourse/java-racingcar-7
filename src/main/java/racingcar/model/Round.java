package racingcar.model;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Round {
    private final LinkedHashMap<String, Integer> state;

    private Round(LinkedHashMap<String, Integer> state) {
        this.state = state;
    }

    public LinkedHashMap<String, Integer> getState() {
        return state;
    }

    public static Round of(List<Car> carList) {
        LinkedHashMap<String, Integer> state = new LinkedHashMap<>();

        carList.forEach(car -> state.put(car.getName(), car.getPosition()));

        return new Round(state);
    }

    public List<String> findAllLeadingCars() {
        int maxValue = state.sequencedValues().stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(Integer.MIN_VALUE);

        return state.sequencedEntrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Entry::getKey)
                .toList();
    }
}
