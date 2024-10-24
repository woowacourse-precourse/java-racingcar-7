package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String carName;
    int location;

    Car(String carName) {
        this.carName = carName;
        location = 0;
    }

    public void go() {
        this.location++;
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
