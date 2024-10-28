package racingcar.model.car;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
