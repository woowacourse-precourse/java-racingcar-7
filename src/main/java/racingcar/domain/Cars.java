package racingcar.domain;

import racingcar.constant.OutputMessage;

import java.util.List;

public class Cars {

    private static int MIN_POSITION = 0;
    private static String COMMA = ", ";

    private final List<Car> elements;

    public Cars(List<Car> elements) {
        this.elements = elements;
    }

    public void moveCars() {
        elements.forEach(Car::move);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(value -> sb.append(value.getResult()).append(OutputMessage.NEW_LINE.getMessage()));
        return sb.toString();
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames= elements.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        return String.join(COMMA, winnerNames);
    }

    private int getMaxPosition() {
        return elements.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }
}
