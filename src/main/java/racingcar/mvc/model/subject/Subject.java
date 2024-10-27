package racingcar.mvc.model.subject;

import racingcar.mvc.model.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers();
}
