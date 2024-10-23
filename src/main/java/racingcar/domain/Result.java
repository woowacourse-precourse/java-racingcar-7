package racingcar.domain;

import java.util.List;

public record Result(
    List<Cars> finalResultCars
) {

    public List<String> findWinners() {
        return Cars.findWinnersName(finalResultCars.getLast().allCar());
    }

    public static Result of(List<Cars> finalResultCars) {
        return new Result(finalResultCars);
    }
}
