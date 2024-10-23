package util;

import java.util.ArrayList;
import racingcar.Car;

public class CarUtility {

    public static ArrayList<Car> makeCarList(String carsWithComma) {
        String[] carNames = carsWithComma.split(",");
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }


}
