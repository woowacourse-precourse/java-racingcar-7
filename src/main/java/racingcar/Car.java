package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.RaceConfig.RANDOM_POINT_NUMBER;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<Car> createCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveOrStop(int randomNumber){
        if(randomNumber >= RANDOM_POINT_NUMBER){
            increaseDistance();
        }
    }

    private void increaseDistance(){
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
