package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void addCar(String name) {
        carList.add(new Car(name));
    }

    public void raceCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<String> getRaceInfos() {
        List<String> raceInfos = new ArrayList<>();
        for (Car car : carList) {
            raceInfos.add(car.getRaceInfo());
        }
        return raceInfos;
    }
}
