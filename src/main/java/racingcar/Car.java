package racingcar;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final String name;
    private String position;

    private Car(String name) {
        this.name = name;
        this.position = "";
    }
    public static Car generateCars(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }
}
