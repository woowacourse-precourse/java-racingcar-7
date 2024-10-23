package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private final List<Car> cars;

    public RaceGame(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        String[] names = RaceUtil.parseCarNames(carNames);
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
