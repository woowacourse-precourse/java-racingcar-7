package racingcar.util.factory;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> carGenerator(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name)); // 이름으로 Car 객체 생성
        }
        return cars;
    }
}
