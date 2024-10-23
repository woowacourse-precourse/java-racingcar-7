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

    public static Cars makeOriginCars(List<String> carNames) {
        ArrayList<Car> allCar = new ArrayList<>();
        for (String name : carNames) {
            allCar.add(new Car(name, 0));
        }
        return new Cars(allCar);
    }

    private static int findLongestDistanceAtFinal(List<Car> finalAllCar) {
        int longestDistance = 0;
        for (Car car : finalAllCar) {
            if (car.distance() > longestDistance) {
                longestDistance = car.distance();
            }
        }
        return longestDistance;
    }

    public static List<String> findWinnersName(List<Car> finalAllCar) {
        int longestDistance = findLongestDistanceAtFinal(finalAllCar);
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
