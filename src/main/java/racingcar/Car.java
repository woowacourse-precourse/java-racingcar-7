package racingcar;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private String name;
    private String position;

    private Car(String name) {
        this.name = name;
        this.position = "";
    }
    public static List<Car> generateCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
