package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private long moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public long getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void move() {
        moveCount++;
    }

    public static List<Car> createCarsByName(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
