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

    public static List<String> getWinnersName(List<Car> entryCars) {
        int maxPosition = entryCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<String> names = entryCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        return names;
    }
}
