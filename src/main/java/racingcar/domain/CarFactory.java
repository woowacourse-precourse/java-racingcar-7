package racingcar.domain;

import java.util.List;

public class CarFactory {

    private static List<String> nameList = List.of();

    public CarFactory(List<String> nameList) {
        this.nameList = nameList;
    }

    public Car makeCar(String carName) {
        return new Car(carName);
    }
}
