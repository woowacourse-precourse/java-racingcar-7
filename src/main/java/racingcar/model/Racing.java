package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    List<Car> carList;

    public Racing(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public void runRacingTurn() {
        for (final Car car : carList) {
            car.goOrStop();
        }
    }
}