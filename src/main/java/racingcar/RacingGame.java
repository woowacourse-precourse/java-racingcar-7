package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void start() {

    }

    private String displayPosition(Car car) {
        String name = car.getName();
        int pos = car.getPosition();

        StringBuilder display = new StringBuilder(name + " : ");
        display.append("-".repeat(pos));

        return display.toString();
    }
}
