package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;

public class RacingService {

    private final RacingStrategy racingStrategy;

    public RacingService(RacingStrategy racingStrategy) {
        this.racingStrategy = racingStrategy;
    }

    public void race(List<Car> cars){
        for(Car car : cars) {
            attemptToForwardCar(car);
        }
    }

    private void attemptToForwardCar(Car car){
        if(racingStrategy.determineCarToForward()) {
            car.forward();
        }
    }
}
