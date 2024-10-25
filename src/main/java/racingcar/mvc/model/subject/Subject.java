package racingcar.mvc.model.subject;

import java.util.List;
import racingcar.mvc.model.observer.CarObserver;

public interface Subject {
    void registerObserver(CarObserver observer);

    void notifyObservers();

    List<CarObserver> findWinnerObservers();
}
