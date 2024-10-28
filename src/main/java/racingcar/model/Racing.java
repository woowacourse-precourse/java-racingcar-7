package racingcar.model;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Racing {
    private final List<RacingCar> cars = new ArrayList<>();

    public Racing(List<String> carNames) {
        initializeCars(carNames);
    }

    public List<RacingCar> findFarthestCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(toList());
    }

    public void run(Supplier<Integer> randomSupplier) {
        for (RacingCar car : cars) {
            car.moveForward(randomSupplier);
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private void initializeCars(List<String> carNames) {
        carNames.stream()
                .map(RacingCar::new)
                .forEach(cars::add);
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
