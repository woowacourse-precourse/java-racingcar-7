package racingcar.model;

import java.util.List;
import racingcar.constant.Movement;

public class RacingCar {
    private static final int INITIAL_LOCATION = 0;

    private final String name;
    private int location;

    public RacingCar(String name) {
        this.name = name;
        this.location = INITIAL_LOCATION;
    }

    public static List<RacingCar> createRacingCars(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void increaseLocation() {
        this.location++;
    }

    public void move(Movement movement) {
        if (movement == Movement.MOVING_FORWARD) {
            increaseLocation();
        }
    }
}
