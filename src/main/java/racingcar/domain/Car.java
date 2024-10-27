package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car implements Comparable<Car> {

    private final String name;
    private final long numOfStages;
    private Map<Long, String> moveHistory;

    public Car(final String name, final long numOfStages) {
        this.name = name;
        this.numOfStages = numOfStages;
        this.moveHistory = new HashMap<>();
    }

    public long getTotalMoves() {
        return this.getMoveHistoryAtStage(this.numOfStages - 1).length();
    }

    public String getName() {
        return this.name;
    }

    public String getMoveHistoryAtStage(long stage) {
        return this.moveHistory.get(stage);
    }

    public void move(long stage) {
        if (stage == 0)
            this.moveHistory.put(stage, "-");
        this.moveHistory.put(stage, this.getMoveHistoryAtStage(stage - 1) + "-");
    }

    public void stop(long stage) {
        if (stage == 0)
            this.moveHistory.put(stage, "");
        this.moveHistory.put(stage, this.getMoveHistoryAtStage(stage - 1));
    }

    @Override
    public int compareTo(Car c) {
        return Long.compare(c.getTotalMoves(), this.getTotalMoves());
    }
}
