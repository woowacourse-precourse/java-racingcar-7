package racingcar.service;

import racingcar.domain.car.Car;

public interface Accelerator {
    public void move(Car car);

    public boolean canMove(int number);
}
