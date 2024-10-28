package racing.game;

import camp.nextstep.edu.missionutils.Randoms;
import racing.game.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
    private static final int MIN_POSITION = 0;
    private static final int THRESHOLD_VALUE = 4;

    private boolean isForward() {
        return Randoms.pickNumberInRange(0, 9) >= THRESHOLD_VALUE;
    }
    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    public void moveCarForward(Car car) {
        if (isForward()) car.moveForward();
    }

    public List<String> getWinnerNames(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
