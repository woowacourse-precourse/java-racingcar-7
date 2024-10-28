package racingcar.model;

import racingcar.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}
