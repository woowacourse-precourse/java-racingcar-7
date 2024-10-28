package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public void showAll() {
        carList.forEach(Car::show);
    }


}
