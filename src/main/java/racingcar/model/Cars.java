package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void set(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> get(){
        return cars;
    }
}
