package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> elements;

    public Cars(List<Car> elements) {
        this.elements = elements;
    }

    public void moveCars() {
        elements.forEach(Car::move);
    }
}
