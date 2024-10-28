package racingcar.model;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }


}
