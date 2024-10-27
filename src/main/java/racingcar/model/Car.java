package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private List<Integer> distance;

    public Car(final String name) {
        this.name = name;
        this.distance = new ArrayList<>();
        this.distance.add(0);
    }

}
