package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public List<Car> setParticipants(String[] splited) {
        List<Car> cars = new ArrayList<>();
        for (String carName : splited) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
