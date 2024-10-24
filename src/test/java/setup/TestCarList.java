package setup;

import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;

import java.util.List;

public class TestCarList {

    public static CarList getTestCarList(List<Car> carList) {
        return CarList.of(carList);
    }
}