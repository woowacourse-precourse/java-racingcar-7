package racingcar.model;

import java.util.List;

public class RacingResult {
    private List<String> winners;

    public List<String> getWinnerNames(Cars cars) {
        determineRacingWinners(cars);
        return winners;
    }

    private void determineRacingWinners(Cars cars) {
        int winnerPosition = cars.getLongestPosition();
        winners = cars.getCars().stream()
                .filter(car -> car.getPosition() >= winnerPosition)
                .map(Car::getCarName)
                .toList();
    }
}
