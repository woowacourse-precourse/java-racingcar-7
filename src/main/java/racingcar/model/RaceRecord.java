package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class RaceRecord {
    private Map<Car,Integer> raceResult;

    public RaceRecord(List<String> CarNames) {
        raceResult = new LinkedHashMap<>();
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

    public Car getOneCar(String carName) {
        for (Car car : raceResult.keySet()) {
            if (car.getName().equals(carName)) {
                return car;
            }
        }
        throw new NoSuchElementException(carName + " not found.");
    }

    public int getOneCarRecord(String carName) {
        for (Map.Entry<Car, Integer> car : raceResult.entrySet()) {
            if (car.getKey().getName().equals(carName)) {
                return car.getValue();
            }
        }
        throw new NoSuchElementException(carName + " not found.");
    }
}