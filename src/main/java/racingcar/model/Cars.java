package racingcar.model;

import java.util.List;


public class Cars { //일급 컬렉션
    List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
