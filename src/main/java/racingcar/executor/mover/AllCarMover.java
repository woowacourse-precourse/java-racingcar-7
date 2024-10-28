package racingcar.executor.mover;

import racingcar.entity.Car;

import java.util.List;

public interface AllCarMover {
    List<Car> run(List<Car> currentHistory);
}
