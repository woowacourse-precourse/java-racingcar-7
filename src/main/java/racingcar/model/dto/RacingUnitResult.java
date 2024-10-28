package racingcar.model.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.model.car.Car;

public class RacingUnitResult {

    Map<Car, Integer> result = new LinkedHashMap<>();

    public void addResult(Car car){
        this.result.put(car, car.getPosition());
    }

    public Map<Car, Integer> getResult() {
        return this.result;
    }

}
