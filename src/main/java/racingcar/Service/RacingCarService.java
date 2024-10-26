package racingcar.Service;

import racingcar.Domain.Car;

import java.util.List;

public class RacingCarService {
    public void runRound(List<Car> cars){
        cars.forEach(Car::move);
    }
}
