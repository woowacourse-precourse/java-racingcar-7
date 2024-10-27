package racingcar.config;

import racingcar.model.Car;
import racingcar.model.RacingCar;

public class Config {
    public Car car(String s){
        return new RacingCar(s);
    }

}
