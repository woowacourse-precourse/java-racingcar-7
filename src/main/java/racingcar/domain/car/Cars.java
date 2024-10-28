package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movement.MovementStrategy;
import racingcar.view.output.RacingRoundView;
import racingcar.view.output.RoundView;

public class Cars {
    private final List<Car> cars;
    private final MovementStrategy moveStrategy;

    private Cars(List<Car> cars, MovementStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public static Cars createCarsFrom(String names, MovementStrategy strategy) {
        List<Car> carList = getCarList(names);

        validateDuplicate(carList);

        return new Cars(carList, strategy);
    }

    private static List<Car> getCarList(String names) {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateDuplicate(List<Car> cars) {
        long distinctCarNameCount = getDistinctCarNameCount(cars);

        if (distinctCarNameCount != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static long getDistinctCarNameCount(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    public void moveAll() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return getWinnerList(maxPosition);
    }

    private List<String> getWinnerList(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public int size() {
        return cars.size();
    }

    public List<RoundView> createRoundResults() {
        return cars.stream()
                .map(car -> new RacingRoundView(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
