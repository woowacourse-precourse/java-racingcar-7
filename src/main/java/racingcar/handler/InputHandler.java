package racingcar.handler;

import racingcar.domain.Car;

import java.util.List;

public interface InputHandler {
    List<Car> carList();
    int tryCount();
}
