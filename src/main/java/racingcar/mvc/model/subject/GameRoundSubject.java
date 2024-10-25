package racingcar.mvc.model.subject;

import java.util.ArrayList;
import java.util.List;
import racingcar.mvc.model.observer.CarObserver;

public class GameRoundSubject implements Subject {
    private List<CarObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(CarObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (CarObserver observer : observers) {
            observer.update();
        }
    }
}
