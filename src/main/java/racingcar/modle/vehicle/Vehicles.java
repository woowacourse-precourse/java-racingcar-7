package racingcar.modle.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.movableStrategy.MoveStrategy;
import racingcar.modle.vehicle.car.Car;

public class Vehicles {
    private final List<Movable> movables;
    private final MoveStrategy moveStrategy;

    public Vehicles(final MoveStrategy moveStrategy) {
        this.movables = new ArrayList<>();
        this.moveStrategy = moveStrategy;
    }

    private Vehicles(final List<Movable> movables, final MoveStrategy moveStrategy) {
        this.movables = movables;
        this.moveStrategy = moveStrategy;
    }

    public void nameSettings(final List<String> names) {
        names.forEach(name -> movables.add(new Car(name)));
    }

    public List<String> names() {
        return movables.stream()
                .map(Movable::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> positions() {
        return movables.stream()
                .map(Movable::getPosition)
                .collect(Collectors.toList());
    }

    public Vehicles moveAll() {
        List<Movable> newMovables = movedMovables();
        return new Vehicles(newMovables, moveStrategy);

    }

    private List<Movable> movedMovables() {
        return movables.stream()
                .map(this::moveEach)
                .collect(Collectors.toList());
    }

    private Movable moveEach(final Movable movable) {
        if (moveStrategy.isMove()) {
            return movable.move(moveStrategy);
        }
        return movable;
    }
}
