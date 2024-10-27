package racingcar;

import java.util.List;

public interface Referee {
    List<Car> checkDrivingDistance(List<Car> carList);
    Car judgeMovement(Car car);
    List<Car> judgeWinner(List<Car> carList);
}
