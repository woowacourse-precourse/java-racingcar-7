package racingcar.mvc.model.subject;

import racingcar.mvc.model.observer.CarObserver;

public interface Subject {
    void registerObserver(CarObserver observer);

    void notifyObservers();
}
