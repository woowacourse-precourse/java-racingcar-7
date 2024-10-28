package racingcar.model;

import java.util.List;
import racingcar.dto.CarDTO;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.distance);
    }

    public void move() {
        this.distance++;
    }

    public String getNameWinner(int maxDistance) {
        if (isWinner(maxDistance)) {
            return name;
        }
        return "";
    }

    public boolean isWinner(int maxDistance) {
        return this.distance == maxDistance;
    }

    public static int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.distance)
                .max()
                .orElse(0);
    }
}
