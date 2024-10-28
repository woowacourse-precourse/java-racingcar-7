package racingcar.model;

import racingcar.config.Config;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars =new ArrayList<>();
    Config config=new Config();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(String s){
        Car car=config.car(s);
        cars.add(car);
    }

}
