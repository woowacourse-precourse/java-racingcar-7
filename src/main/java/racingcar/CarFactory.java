package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarFactory {
    public List<Car> createCar(StringTokenizer carNameToken) {
        List<Car> cars = new ArrayList<>();
        while (carNameToken.hasMoreTokens()) {
            cars.add(new Car(carNameToken.nextToken()));
        }
        return cars;
    }
}
