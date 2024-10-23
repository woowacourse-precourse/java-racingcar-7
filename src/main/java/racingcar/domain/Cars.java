package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Cars(
        List<Car> allCar
) {

    public static List<Cars> makeOriginCars(List<String> carNames) {
        Cars cars = new Cars(Car.makeCars(carNames));
        List<Cars> result = new ArrayList<>();
        result.add(cars);
        return result;
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

    public String makeResultOutput() {
        StringBuilder resultString = new StringBuilder();
        for (Car car : allCar) {
            resultString.append(car.makingCarDistanceResult());
            resultString.append('\n');
        }
        return resultString.toString();
    }
}
