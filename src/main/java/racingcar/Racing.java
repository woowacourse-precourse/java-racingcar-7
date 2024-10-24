package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
