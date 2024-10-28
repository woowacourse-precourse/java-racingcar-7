package racingcar.service.race;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.constant.ExpressionFormat;

public class WinnerService {
    private List<String> winners;
    private Long farthest;

    public WinnerService(List<Car> finishers) {
        findWinningPosition(finishers);
        pickWinners(finishers);
    }

    private void findWinningPosition(List<Car> finishers) {
        farthest = finishers.stream()
                .mapToLong(Car::getMileage)
                .max()
                .orElse(0L);
    }

    private void pickWinners(List<Car> finishers) {
        winners = finishers.stream()
                .filter(car -> car.getMileage().equals(farthest))
                .map(Car::getName)
                .toList();
    }
}
