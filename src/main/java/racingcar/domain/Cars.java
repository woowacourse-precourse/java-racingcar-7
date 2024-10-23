package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.RandomNumberGenerator;

public record Cars(
    List<Car> allCar
) {

    public Cars eachGame() {
        List<Car> result = new ArrayList<>();
        for (Car car : allCar) {
            Car resultCar = car.updateDistance(car, RandomNumberGenerator.isFollowNumberRule());
            result.add(resultCar); //네이밍
        }
        return new Cars(result);
    }

    public static List<Cars> makeOriginCars(List<String> carNames) {
        Cars cars = new Cars(Car.makeCars(carNames));
        List<Cars> result = new ArrayList<>();
        result.add(cars);
        return result;
    }

    private static int findLongestDistance(List<Car> finalAllCar) {
        int longestDistance = 0;
        for (Car car : finalAllCar) {
            if (car.distance() > longestDistance) {
                longestDistance = car.distance();
            }
        }
        return longestDistance;
    }

    public static List<String> findWinnersName(List<Car> finalAllCar) {
        int longestDistance = findLongestDistance(finalAllCar);
        List<String> winners = new ArrayList<>();
        for (Car car : finalAllCar) {
            if (car.distance() == longestDistance) {
                winners.add(car.name());
            }
        }
        return winners;
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
