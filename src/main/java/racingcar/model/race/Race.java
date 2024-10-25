package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.InitCars;
import racingcar.model.random.Random;

public class Race {
    List<Car> carList;
    public int attemptCountNumber;

    public Race(String[] carNameArray, int attemptCountNumber) {
        carList = InitCars.initCars(carNameArray);
        this.attemptCountNumber = attemptCountNumber;
    }

    public final String turnRun() {
        StringBuilder turnResult = new StringBuilder();
        for (Car car : carList) {
            Random.goRandomForward(car);
            turnResult.append(car.toString()).append("\n");
        }
        return turnResult.toString();
    }

    public final String raceRun() {
        StringBuilder raceResult = new StringBuilder();
        while (attemptCountNumber-- > 0) {
            String turnResult = turnRun();
            raceResult.append(turnResult).append("\n");
        }
        return raceResult.toString();
    }
}
