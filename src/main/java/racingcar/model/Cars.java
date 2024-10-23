package racingcar.model;

import java.util.ArrayList;
import java.util.List;


public class Cars { //일급 컬렉션
    List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
