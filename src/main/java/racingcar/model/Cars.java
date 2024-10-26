package racingcar.model;

import racingcar.provider.NumberProvider;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> move(NumberProvider numberProvider) {
        cars.forEach(car -> car.move(numberProvider.getNumber()));
        return cars;
    }

    public List<Car> getWinnerCars() {
        List<Car> winnerCars = new ArrayList<>(cars);

        int maxPosition = calculateMaxPosition(winnerCars);
        winnerCars.removeIf(car -> car.isNotSamePositionTo(maxPosition));

        return winnerCars;
    }

    private int calculateMaxPosition(final List<Car> winnerCars) {
        return winnerCars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }

}
