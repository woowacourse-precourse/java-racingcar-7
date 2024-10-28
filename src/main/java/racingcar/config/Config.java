package racingcar.config;

import racingcar.model.car_object.Car;
import racingcar.model.car_object.RacingCar;

public class Config {
    public Car car(String name) {
        return new RacingCar(name);
    }
}
