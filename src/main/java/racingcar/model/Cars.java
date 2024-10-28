package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNames) {
        carList = new ArrayList<>();
        for(String carName : carNames)
            carList.add(new Car(carName));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
