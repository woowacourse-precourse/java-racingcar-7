package racingcar;

import java.util.ArrayList;

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
        String currentPosition = "";
        for (int i = 0; i < position; i++) {
            currentPosition += "-";
        }
        return currentPosition;
    }

    public void moveForward() {
        this.position += 1;
    }

    public static ArrayList<Car> makeCarArrayList(String[] carnames){
        ArrayList<Car> cars = new ArrayList<>();
        for (String carname : carnames) {
            Car newcar = new Car(carname);
            cars.add(newcar);
        }
        return cars;
    }
}
