package racingcar.modle.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.modle.movableStrategy.MovableStrategy;
import racingcar.modle.vehicle.car.Car;

public class Vehicles {
    private final List<Movable> movables;
    private final MovableStrategy movableStrategy;

    public Vehicles (MovableStrategy movableStrategy) {
        this.movables = new ArrayList<>();
        this.movableStrategy = movableStrategy;
    }

    private Vehicles (List<Movable> movables, MovableStrategy movableStrategy) {
        this.movables = movables;
        this.movableStrategy = movableStrategy;
    }

    public void nameSettings(List<String> names) {
        names.forEach(name -> movables
                .add(new Car(name, movableStrategy)));
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

    public Vehicles move() {
        List<Movable> newMovables = movedMovables();
        return new Vehicles(newMovables, movableStrategy);

    }
    private List<Movable> movedMovables() {
        return movables.stream()
                .map(this::moveEach)
                .collect(Collectors.toList());
    }
    private Movable moveEach (Movable movable) {
        if(movableStrategy.isMove()){
            return movable.move();
        }
        return movable;
    }

    public List<Movable> movables() {
        return movables;
    }
}
