package racingcar.service;

import racingcar.domain.car.Car;

public interface Accelerator {

    void move(Car car);

    boolean canMove(int number);
}
