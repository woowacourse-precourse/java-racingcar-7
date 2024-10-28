package racingcar.Model;

import java.util.ArrayList;

public class Race {

    private ArrayList<Car> cars;

    public Race(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
