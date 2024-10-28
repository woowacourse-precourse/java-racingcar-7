package racingcar.model.dto;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.car.Car;

public class RacingUnitResult {

    Map<Car, Integer> result = new HashMap<>();

    public void addResult(Car car){
        this.result.put(car, car.getPosition());
    }

}
