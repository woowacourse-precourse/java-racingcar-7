package racingcar.observer;

import racingcar.car.Car;

public interface CarObserver {
    void onMoved(Car car);
}
