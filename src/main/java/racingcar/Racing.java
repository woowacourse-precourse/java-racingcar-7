package racingcar;

import java.util.ArrayList;

public class Racing {
    public void run(String[] names, int count) {
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
