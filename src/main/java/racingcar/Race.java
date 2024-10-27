package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<Car> start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
        }
        return getWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX) >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
