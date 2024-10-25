package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private List<Car> cars;

    public CarManager(){
        this.cars = new ArrayList<>();
    }

    public void initCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

}
