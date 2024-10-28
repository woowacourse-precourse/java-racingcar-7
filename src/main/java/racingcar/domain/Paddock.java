package racingcar.domain;

import java.util.List;

public class Paddock {

    private final List<Car> openField;

    public Paddock(List<Car> openField) {
        this.openField = openField;
    }

    public List<Car> getEntry() {
        return openField;
    }
}
