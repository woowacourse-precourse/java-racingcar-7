package racingcar.domain;

import racingcar.constant.OutputMessage;

import java.util.List;

public class Cars {

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
}
