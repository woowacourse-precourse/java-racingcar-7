package racingcar.config;

import racingcar.model.Car;
import racingcar.model.RacingCar;

public class Config {
    public Car car(){
        return new RacingCar();
    }

}
