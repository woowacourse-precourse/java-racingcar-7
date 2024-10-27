package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Cars(
        List<Car> allCar
) {

    public static Cars make(List<String> carNames) {
        List<Car> allCar = new ArrayList<>();
        for (String name : carNames) {
            allCar.add(Car.make(name));
        }
        return new Cars(allCar);
    }

    public int findLongestDistance() {
        int longestDistance = 0;
        for (Car car : allCar) {
            if (car.distance() > longestDistance) {
                longestDistance = car.distance();
            }
        }
        return longestDistance;
    }
}
