package racingcar.domain;

import java.util.List;

public class RaceResult {

    private final Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.getMaxPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

}
