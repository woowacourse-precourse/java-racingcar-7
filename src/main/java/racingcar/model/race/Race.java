package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Car;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(){
        for(Car car : cars){
           car.move();
        }
    }
}
