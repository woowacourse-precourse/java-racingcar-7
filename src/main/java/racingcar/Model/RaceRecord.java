package racingcar.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceRecord {
    private Map<Car,Integer> raceResult;

    public RaceRecord(List<String> CarNames) {
        raceResult = new HashMap<>();
        for (String carName : CarNames) {
            Car car = new Car(carName);
            raceResult.put(car, 0);
        }
    }

    public Map<Car,Integer> getRaceResult() {
        return raceResult;
    }

    public void updateCarRecord(Car car, int moveCount) {
        raceResult.put(car, raceResult.get(car) + moveCount);
    }

}
