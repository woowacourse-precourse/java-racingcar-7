package racingcar.service.race;

import java.util.List;
import racingcar.domain.Car;

public class WinnerService {
    private List<String> winners;
    private Long farthest;

    public WinnerService(List<Car> finishers) {
        findWinningPosition(finishers);
    }

    private void findWinningPosition(List<Car> finishers) {
        farthest = finishers.stream()
                .mapToLong(Car::getMileage)
                .max()
                .orElse(0L);
    }
}
