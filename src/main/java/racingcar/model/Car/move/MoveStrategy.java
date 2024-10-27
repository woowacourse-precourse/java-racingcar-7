package racingcar.model.Car.move;

import racingcar.model.Car.Car;

import java.util.List;

public interface MoveStrategy {
    int MOVE_NUM_PER_RADE = 1;
    int MOVE_STANDARD = 4;
    void move(List<Car> cars);
}
