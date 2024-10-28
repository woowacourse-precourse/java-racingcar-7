package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarNameParser {
    public List<Car> parse(String carNames) {
        List<Car> cars = new ArrayList<>();
        for(String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
