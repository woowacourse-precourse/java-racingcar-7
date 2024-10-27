package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingService {

    private final RacingStrategy racingStrategy;

    public RacingService(RacingStrategy racingStrategy) {
        this.racingStrategy = racingStrategy;
    }

    public void race(Cars cars){
        for(Car car : cars.getCars()) {
            attemptToForwardCar(car);
        }
    }

    private void attemptToForwardCar(Car car){
        if(racingStrategy.determineCarToForward()) {
            car.forward();
        }
    }
}
