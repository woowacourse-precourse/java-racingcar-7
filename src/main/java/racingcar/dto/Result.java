package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.constant.Message;
import racingcar.model.Car;

public class Result {
    private final Map<String, Integer> result;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private Result(Map<String, Integer> result) {
        this.result = result;
    }

    public static Result of(List<Car> cars) {
        Map<String, Integer> result = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getCurrentPosition,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return new Result(result);
    }

    public String middleResult() {
        return result.entrySet().stream()
                .map(entry -> String.format(Message.RESULT_DISPLAY_FORMAT, entry.getKey(), "-".repeat(entry.getValue())))
                .collect(Collectors.joining(LINE_SEPARATOR, "", LINE_SEPARATOR));
    }

    public String finalResult() {
        return String.format(Message.FINAL_RESULT, String.join(", ", result.keySet()));
    }
}
