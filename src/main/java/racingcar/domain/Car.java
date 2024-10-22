package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private List<String> moveHistory;

    public Car(String name, int numberOfMoves) {
        this.name = name;
        this.moveHistory = new ArrayList<>(numberOfMoves);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getMoveHistory() {
        return this.moveHistory;
    }
}
