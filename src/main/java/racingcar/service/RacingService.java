package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public void separateCarNames (String namesOfCars) {
        List<String> nameOfCar = new ArrayList<>();
        nameOfCar = List.of(namesOfCars.split(","));
    }

    public void race (int numberOfRaces) {
        while (numberOfRaces > 0) {

            numberOfRaces--;
        }
    }
}
