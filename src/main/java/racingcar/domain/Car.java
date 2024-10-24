package racingcar.domain;

import java.util.List;

public class Car {

    private final List<String> cars;

    public Car(String input) {
        String[] split = input.split(",");
        List<String> cars = List.of(split);
        this.cars = cars;
    }

    public List<String> getCars() {
        return cars;
    }

}