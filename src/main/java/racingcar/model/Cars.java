package racingcar.model;

import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName, new CarNameValidator()));
        }
    }

    public List<Car> getCars(){
        return this.cars;
    }
}
