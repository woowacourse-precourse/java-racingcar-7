package racingcar;

import racingcar.car.Car;
import racingcar.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final int numberOfTurn;
    private final List<Car> entryCars;

    private Observer resultObserver;
    private Observer executeObserver;

    public CarGame(int numberOfTurn, List<Car> entryCars) {
        this.numberOfTurn = numberOfTurn;
        this.entryCars = entryCars;
    }
    private void moveCars() {
        this.entryCars.forEach(Car::forward);
    }

    public void play() {
        for (int i = 0 ; i < numberOfTurn; i++) {
            moveCars();
            executeObserver.notifyUpdate();
        }
        resultObserver.notifyUpdate();
    }
    public void subscribeResultObserver(Observer resultObserver) {
        this.resultObserver = resultObserver;
    }
    public void subscribeExecuteObserver(Observer executeObserver) {
        this.executeObserver = executeObserver;
    }
}
