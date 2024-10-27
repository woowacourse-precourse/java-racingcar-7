package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.Observer;

public class Cars {
    private final List<Car> cars;
    private List<Observer> observers;

    public Cars(List<Car> cars) {
        this.cars = cars;
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void moveCars(int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            cars.forEach(Car::move);
            notifyObserver();
        }
    }

    private void notifyObserver() {
        observers.forEach(observer -> observer.update(this));
    }

    public List<String> findWinnerNames() {
        int maxMoveDistance = Collections.max(
                cars.stream()
                        .map(Car::getMoveDistance)
                        .toList()
        );
        return cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
