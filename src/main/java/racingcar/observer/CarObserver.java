package racingcar.observer;

import racingcar.Car;

public interface CarObserver {
    void onMoved(Car car);
}
