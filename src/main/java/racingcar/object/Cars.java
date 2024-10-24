package racingcar.object;

import java.util.Comparator;
import java.util.List;
import racingcar.object.value.CarRecord;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public void raceAll() {
        cars.forEach(Car::tryDrive);
    }

    public List<CarRecord> submitRecords() {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getCarName))
                .map(Car::record)
                .toList();
    }

}
