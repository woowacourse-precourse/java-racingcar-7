package racingcar.executor.decider.winner;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerListDeciderImpl implements WinnerListDecider {
    @Override
    public List<String> findWinners(List<Car> racingHistory) {
        int maxDistance = racingHistory.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : racingHistory)
            if (car.getDistance() == maxDistance)
                winners.add(car.getCarName());

        return winners;
    }
}
