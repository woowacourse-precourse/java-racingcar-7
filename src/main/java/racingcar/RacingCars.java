package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList;
    public RacingCars(String readLine) {
        List<Car> tmpList = new ArrayList<>();
        String[] nameArray = readLine.split(",");
        for (String name : nameArray) {
            Car car = new Car(name);
            tmpList.add(car);
        }
        this.carList = tmpList;
    }
}
