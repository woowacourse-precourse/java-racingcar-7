package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car implements Comparable<Car> {

    private final String name;
    private long totalMoves;
    private Map<Long, String> moveHistory;

    public Car(String name, long numberOfStages) {
        this.name = name;
        this.moveHistory = new HashMap<>();
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

    public String getMoveAtStage(long stage) {
        return this.moveHistory.get(stage);
    }

    public Map<Long, String> getMoveHistory() {
        return this.moveHistory;
    }

    @Override
    public int compareTo(Car c) {
        return Long.compare(c.totalMoves, this.totalMoves);
    }
}
