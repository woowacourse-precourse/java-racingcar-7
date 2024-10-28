package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars,int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }


}
