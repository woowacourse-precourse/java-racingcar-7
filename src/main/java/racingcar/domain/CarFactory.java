package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> generateCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for(String carNmae : carNames){
            cars.add(new Car(carNmae));
        }
        return cars;
    }
}
