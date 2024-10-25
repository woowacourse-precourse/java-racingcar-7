package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private List<Car> cars;

    public CarManager(){
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

    public void addCar(Car car){
        cars.add(car);
    }

}
