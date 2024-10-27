package racingcar.modle.vehicle;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.modle.movableStrategy.MovableStrategy;
import racingcar.modle.vehicle.car.CarFactory;

public class Vehicles {
    private final List<Movable> vehicles;

    public Vehicles (List<String> names, MovableStrategy movableStrategy) {
        this.vehicles = names.stream()
                .map(new CarFactory(movableStrategy)::create)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return vehicles.stream()
                .map(Movable::getName)
                .toList();
    }

    public List<Integer> getPositions() {
        return vehicles.stream()
                .map(Movable::getPosition)
                .toList();
    }
}
