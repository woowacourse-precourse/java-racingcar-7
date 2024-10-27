package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.interfaces.car.CarsResponse;

public class RacingService {

    private final RacingStrategy racingStrategy;

    public RacingService(RacingStrategy racingStrategy) {
        this.racingStrategy = racingStrategy;
    }

    public CarsResponse race(Cars cars){
        for(Car car : cars.getCars()) {
            attemptToForwardCar(car);
        }
        return CarsResponse.from(cars);
    }

    private void attemptToForwardCar(Car car){
        if(racingStrategy.determineCarToForward()) {
            car.forward();
        }
    }
}
