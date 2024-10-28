package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingHistory {

    private final List<String> history;

    private RacingHistory(List<Car> cars) {
        this.history = toHistoryFormat(cars);
    }

    public static RacingHistory of(List<Car> cars) {
        return new RacingHistory(cars);
    }

    public String joinHistory(String delimiter) {
        return String.join(delimiter, history);
    }

    private List<String> toHistoryFormat(List<Car> cars) {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
