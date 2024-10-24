package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Car {

    private final List<String> cars;

    private Car(List<String> cars) {
        this.cars = cars;
    }

    public static Car from(String input) {
        return new Car(splitByComma(input));
    }

    public List<String> getCars() {
        return cars;
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

}