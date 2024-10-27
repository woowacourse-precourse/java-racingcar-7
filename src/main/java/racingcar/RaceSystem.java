package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceSystem {
    private static final int MIN_MOVE_CONDITION = 4;
    private List<Car> cars;
    private int raceTime;

    public RaceSystem(List<String> carNames, int raceTime) {
        this.cars = new ArrayList<>();
        for (String carName: carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
        this.raceTime = raceTime;
    }
}
