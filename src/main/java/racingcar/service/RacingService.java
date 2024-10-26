package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public void separateCarNames (String namesOfCars) {
        List<String> nameOfCar = new ArrayList<>();
        nameOfCar = List.of(namesOfCars.split(","));

        for (String a : nameOfCar) {
            System.out.println(a);
        }
    }
}
