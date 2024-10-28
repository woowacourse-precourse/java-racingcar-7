package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Result(
        List<Cars> finalResultCars
) {

    public List<String> findWinners() {
        Cars finalCars = finalResultCars.getLast();
        int longestDistance = finalCars.findLongestDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : finalCars.allCar()) {
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
