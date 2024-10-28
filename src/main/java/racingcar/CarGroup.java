package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {

    private final List<Car> cars;

    CarGroup(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void accelerateAll() {
        for (Car car : cars) {
            car.accelerate();
        }
    }

    private int getLongestMileage() {
        return cars.stream()
                .mapToInt(Car::getMileage)
                .max()
                .orElse(0);
    }

    public List<Car> getLongestMileageCars() {
        int longestMileage = getLongestMileage();
        return cars.stream()
                .filter(car -> car.getMileage() == longestMileage)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String getDrivingRecords() {
        return cars.stream()
                .map(Car::getDrivingRecord)
                .collect(Collectors.joining("\n"));
    }
}
