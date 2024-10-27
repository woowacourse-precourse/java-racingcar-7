package racingcar.model.game;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class PositionBasedReferee implements Referee {
    @Override
    public Winners judgeWinners(Cars cars) {
        List<Car> maxPositionCars = cars.getMaxPositionCars();
        return new Winners(maxPositionCars);
    }
}
