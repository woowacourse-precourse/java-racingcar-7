package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<String> cars = new ArrayList<>();

    public List<String> getCars() {
        return cars;
    }

    public void setCarNames(List<String> cars) {
        this.cars = cars;
    }
}