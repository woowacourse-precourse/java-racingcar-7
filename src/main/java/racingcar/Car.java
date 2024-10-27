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
        return carNames.stream().map(Car::new).toList();
    }
}
