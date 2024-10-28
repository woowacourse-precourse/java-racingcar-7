package racingcar.referee;

import java.util.List;
import racingcar.car.Car;

public interface Referee {
    List<Car> checkDrivingDistance(List<Car> carList);
    Car judgeMovement(Car car);
    List<Car> judgeWinner(List<Car> carList);
}
