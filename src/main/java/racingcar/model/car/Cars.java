package racingcar.model.car;

import static racingcar.model.ExceptionMessages.Cars.DUPLICATE_CAR_NAME;
import static racingcar.model.ExceptionMessages.Cars.NO_REGISTERED_CARS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        validateUniqueName(names);

        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateUniqueName(String[] names) {
        Set<String> uniqueNames = new HashSet<>(List.of(names));

        if (names.length != uniqueNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public boolean hasFewerNumberOfCarsThan(int minimumNumberOfCars) {
        return cars.size() < minimumNumberOfCars;
    }

    public List<CarSnapshot> getSnapshots(int currentRound) {
        return cars.stream().map(car -> new CarSnapshot(car.getName(), car.getPosition(), currentRound)).toList();
    }

    public int getSize() {
        return cars.size();
    }

    public void move(int index) {
        cars.get(index).move();
    }

    public List<Car> getMaxPositionCars() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(NO_REGISTERED_CARS));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
