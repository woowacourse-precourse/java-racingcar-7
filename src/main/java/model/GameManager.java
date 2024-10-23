package model;

import java.util.List;

public class GameManager {
    private List<Car> carList;
    private int runTimes;

    public GameManager(List<String> cars, int runTimes) {
        this.runTimes = runTimes;
        for (String carName : cars) {
            this.carList.add(new Car(carName));
        }
    }


}
