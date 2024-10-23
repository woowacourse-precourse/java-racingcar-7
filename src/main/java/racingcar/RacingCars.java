package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars = new ArrayList<>();

    public void add(RacingCar car) {
        cars.add(car);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isWinner(maxPosition))
            .map(RacingCar::getName)
            .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }
}
