package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Result(
    List<Cars> finalResultCars
) {

    public List<String> findWinners() {
        List<Car> finalCars = finalResultCars.getLast().allCar();
        int longestDistance = Cars.findLongestDistance(finalResultCars.getLast().allCar());
        List<String> winners = new ArrayList<>();
        for (Car car : finalCars) {
            if (car.distance() == longestDistance) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    public static Result of(List<Cars> finalResultCars) {
        return new Result(finalResultCars);
    }
}
