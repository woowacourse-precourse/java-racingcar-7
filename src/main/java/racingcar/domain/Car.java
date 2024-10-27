package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private final String name;
    private long totalMoves;
    private List<String> moveHistory;

    public Car(String name, long numberOfStages) {
        this.name = name;
        this.moveHistory = new ArrayList<>((int) numberOfStages);
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }

    public long getTotalMoves() {
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
        return Long.compare(c.totalMoves, this.totalMoves);
    }
}
