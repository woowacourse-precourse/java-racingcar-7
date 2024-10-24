package racingcar.modle.vehicle.car;

import java.util.List;
import racingcar.modle.vehicle.Vehicles;

public class Cars implements Vehicles {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(new CarFactory()::create)
                .toList();
    }

    @Override
    public List<String> getVehicleNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }
    @Override
    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
