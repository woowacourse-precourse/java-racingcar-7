package racingcar;

import java.util.ArrayList;

public class GameInitializer {
    private ArrayList<Car> cars = new ArrayList<>();

    public void gameInitialize(String[] names) {
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
