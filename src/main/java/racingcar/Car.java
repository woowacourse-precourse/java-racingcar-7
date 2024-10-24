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

    public static List<Car> makeCarList(String[] carnames){
        List<Car> cars = new ArrayList<>();
        for (String carname : carnames) {
            Car newcar = new Car(carname);
            cars.add(newcar);
        }
        return cars;
    }
}
