package racingcar.domain.lap;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.moveProvider.MoveProvider;
import racingcar.dto.LapResult;

public class Lap {

    private final List<Car> cars;
    private final MoveProvider moveProvider;
    private int lapNumber = 1;

    public Lap(List<Car> cars, MoveProvider moveProvider) {
        this.cars = cars;
        this.moveProvider = moveProvider;
    }

    public LapResult oneLap() {
        cars.forEach(car -> car.move(moveProvider.canMove()));
        return LapResult.fromCars(lapNumber++, cars);
    }
}