package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String carName;
    int position;

    Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public static List<Car> makeCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }
}
