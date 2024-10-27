package racingcar.model;

import java.util.List;

public class CarRacingGame extends RacingGame {

    private CarRacingGame(int tryCount, List<Car> carList) {
        super(tryCount, carList);
    }

    public static CarRacingGame createRacingGame(int tryCount, List<Car> carList) {
        return new CarRacingGame(tryCount, carList);
    }

    public List<Car> getCarList() {
        return vehicles;
    }
}
