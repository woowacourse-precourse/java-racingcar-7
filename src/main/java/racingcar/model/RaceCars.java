package racingcar.model;

import static racingcar.model.Race.raceStart;

import java.util.ArrayList;
import java.util.List;

public class RaceCars {
    public static List<Car> makeCarList(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car newcar = new Car(carName);
            cars.add(newcar);
        }
        return cars;
    }

    public static List<Car> race(List<String> carNames, int count) {
        List<Car> cars = makeCarList(carNames);
        return raceStart(count, cars);
    }
}
