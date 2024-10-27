package racingcar;

import racingcar.car.Car;
import racingcar.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final int numberOfTurn;
    private final List<Car> entryCars;
    private final List<Observer> resultObservers;

    public CarGame(int numberOfTurn, List<Car> entryCars) {
        this.numberOfTurn = numberOfTurn;
        this.entryCars = entryCars;
        this.resultObservers = new ArrayList<>();
    }
    private void moveCars() {
        this.entryCars.forEach(Car::forward);
    }

    public void play() {
        for (int i = 0 ; i < numberOfTurn; i++) {
            moveCars();
        }
        resultObservers.forEach(Observer::notifyUpdate);
    }

    public void appendObserver(Observer observer) {
        this.resultObservers.add(observer);
    }
}
