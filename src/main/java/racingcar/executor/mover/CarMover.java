package racingcar.executor.mover;

import racingcar.entity.Car;

import java.util.List;

public interface CarMover {
    List<Car> run(List<Car> currentHistory);
}
