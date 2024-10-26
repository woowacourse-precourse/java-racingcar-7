package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars(){
        return this.cars;
    }
}
