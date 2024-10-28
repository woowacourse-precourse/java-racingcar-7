package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public static List<Car> generate(String carName) {
        List<Car> racingCars = new ArrayList<>();
        String[] names = carName.split(",");

        Arrays.stream(names)
                .forEach(name -> racingCars.add(new Car(name)));

        return racingCars;
    }
}
