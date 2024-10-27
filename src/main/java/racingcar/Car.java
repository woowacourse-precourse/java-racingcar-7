package racingcar;

import racingcar.observer.CarObserver;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private final List<CarObserver> observers = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (CarObserver observer : observers) {
            observer.onMoved(this);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
        notifyObservers(); // 움직임 상태 변경 시 알림
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}