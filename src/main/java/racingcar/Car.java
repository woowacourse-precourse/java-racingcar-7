package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCurrentPositionString(){
        return "-".repeat(position);
    }

    public void moveForward() {
        this.position += 1;
    }

    public static List<Car> makeCarList(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car newcar = new Car(carName);
            cars.add(newcar);
        }
        return cars;
    }
}
