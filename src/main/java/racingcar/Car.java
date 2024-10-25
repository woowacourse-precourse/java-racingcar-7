package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<String> positions;

    public Car(String input) {
        this.name = input;
        this.positions = new ArrayList<>();
    }
}
