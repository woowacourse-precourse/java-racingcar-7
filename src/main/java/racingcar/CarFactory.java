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

    public List<String> createCarNameList(String carNames) {
        StringTokenizer carNameToken = new StringTokenizer(carNames, ",");
        List<String> cars = new ArrayList<>();
        while (carNameToken.hasMoreTokens()) {
            cars.add(carNameToken.nextToken());
        }
        return cars;
    }
}
