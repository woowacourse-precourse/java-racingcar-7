package racingcar.car;

import racingcar.decider.Decider;
import racingcar.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CarUpdater implements Car {
    private final CarImpl car;
    private final Decider decider;
    private final List<Observer> observers;
    public CarUpdater(CarImpl car, Decider decider) {
        this.car = car;
        this.decider = decider;
        this.observers = new ArrayList<>();
    }
    public void forward() {
        if (this.decider.decideMoveOrNot()) {
            this.car.forward();
        }
        observers.forEach(Observer::notifyUpdate);
    }

    public String getName() {
        return this.car.getName();
    }

    public int getPosition() {
        return this.car.getPosition();
    }

    public void append(Observer observer) {
        observers.add(observer);
    }
}
