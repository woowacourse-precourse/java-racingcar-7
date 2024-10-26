package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class TextFormatter {

    public String[] splitCarNamesByComma(String carNames) {
        return carNames.split(",");
    }

    public String getWinnerNames(List<Car> winners) {
        return winners.stream()
                      .map(Car::getName)
                      .collect(Collectors.joining(", "));
    }
}
