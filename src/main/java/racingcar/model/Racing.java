package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Racing {
    private final List<RacingCar> cars = new ArrayList<>();

    public Racing(List<String> carNames) {
        initializeCars(carNames);
    }

    public List<RacingCar> findFarthestCars() {
        int maxPosition = getMaxPos();
        return cars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(toList());
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public void run(Supplier<Integer> randomSupplier) {
        for (RacingCar car : cars) {
            car.moveForward(randomSupplier);
        }
    }

    private void initializeCars(List<String> carNames) {
        carNames.stream()
                .map(RacingCar::new)
                .forEach(cars::add);
    }

    private int getMaxPos() {
        return cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
