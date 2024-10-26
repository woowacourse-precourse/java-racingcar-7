package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsGroup {

    private static List<Car> cars = new ArrayList<>();

    RacingCarsGroup(List<Car> cars) {
        this.cars = cars;
    }

}
