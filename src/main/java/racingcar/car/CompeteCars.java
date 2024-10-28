package racingcar.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.strategy.MoveStrategy;

public class CompeteCars {
    private static final String ERROR_CAR_NAME_DUPLICATION = "자동차 이름은 중복될 수 없습니다.";
    private final List<Car> cars = new ArrayList<>();

    private void validateDuplicatedCar() {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if (uniqueCars.size() < cars.size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATION);
        }
    }

    public CompeteCars(List<String> carNames) {
        validateDuplicatedCar();
        carNames.stream().map(Car::new).forEach(cars::add);
    }

    public void moveAll(MoveStrategy moveStrategy) {
        cars.forEach(moveStrategy::move);
    }

    public Map<String, Integer> getCarsCurrentPosition() {
        return cars.stream().collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public int getCarsMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<String> getWinnerCars() {
        int maxPosition = getCarsMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).toList();
    }
}
