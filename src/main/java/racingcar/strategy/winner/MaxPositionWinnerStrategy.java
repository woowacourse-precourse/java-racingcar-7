package racingcar.strategy.winner;

import racingcar.domain.Car;
import racingcar.exception.domain.RaceErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class MaxPositionWinnerStrategy implements WinnerStrategy {
    @Override
    public List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(RaceErrorMessages.RACE_NOT_START.getMessage()));

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
