package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.RandomNumberGenerator;

public record Cars(
    List<Car> allCar
) {

    public Cars eachGame() {
        List<Car> afterEachRaceCars = new ArrayList<>();
        for (Car car : allCar) {
            Car updateCar = car.updateDistance(car, RandomNumberGenerator.isFollowNumberRule());
            afterEachRaceCars.add(updateCar);
        }
        return new Cars(afterEachRaceCars);
    }

    public static List<Cars> makeOriginCars(List<String> carNames) {
        Cars cars = new Cars(Car.makeCars(carNames));
        List<Cars> result = new ArrayList<>();
        result.add(cars);
        return result;
    }

    public static int findLongestDistance(List<Car> finalAllCar) {
        int longestDistance = 0;
        for (Car car : finalAllCar) {
            if (car.distance() > longestDistance) {
                longestDistance = car.distance();
            }
        }
        return longestDistance;
    }

    public static String makeResultOutput(List<Car> allCar) {
        StringBuilder resultString = new StringBuilder();
        for (Car car : allCar) {
            resultString.append(car.makingCarDistanceResult());
            resultString.append('\n');
        }
        return resultString.toString();
    }
}
