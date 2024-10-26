package racingcar.strategy.winner;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class MaxPositionWinnerStrategy implements WinnerStrategy {

    @Override
    public List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주가 시작되지 않았습니다."));

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
