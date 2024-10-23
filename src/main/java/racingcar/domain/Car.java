package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private final String name;
    private int totalMoves;
    private List<String> moveHistory;

    public Car(String name, int numberOfMoves) {
        this.name = name;
        this.moveHistory = new ArrayList<>(numberOfMoves);
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }

    public int getTotalMoves() {
        return this.totalMoves;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getMoveHistory() {
        return this.moveHistory;
    }

    @Override
    public int compareTo(Car c) {
        return c.totalMoves - this.totalMoves;
    }
}
