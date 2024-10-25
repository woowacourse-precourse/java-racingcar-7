package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.InitCars;

public class Race {
    List<Car> carList;
    public final int attemptCountNumber;


    public Race(String[] carNameArray, int attemptCountNumber) {
        carList = InitCars.initCars(carNameArray);
        this.attemptCountNumber = attemptCountNumber;
    }

    public void raceRun() {

    }
}
