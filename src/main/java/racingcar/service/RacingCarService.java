package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {
    private List<Car> carList = new ArrayList<>();

    public void prepareCars(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public void startRace() {
    }
}
