package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Car implements Comparable<Car> {

    private static final String UNIT_MOVEMENT = "-";
    private static final String DEFAULT_HISTORY = "";
    private final String name;
    private final long numOfStages;
    private Map<Long, String> moveHistory;

    public Car(final String name, final long numOfStages) {
        this.name = name;
        this.numOfStages = numOfStages;
        this.moveHistory = new HashMap<>();
    }

    public void move(final long stage) {
        if (stage == 0)
            this.moveHistory.put(stage, UNIT_MOVEMENT);
        else
            this.moveHistory.put(stage, this.getMoveHistoryAtStage(stage - 1) + UNIT_MOVEMENT);
    }

    public void stop(final long stage) {
        if (stage == 0)
            this.moveHistory.put(stage, DEFAULT_HISTORY);
        else
            this.moveHistory.put(stage, this.getMoveHistoryAtStage(stage - 1));
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public long getTotalMoves() {
        return this.getMoveHistoryAtStage(this.numOfStages - 1).length();
    }

    public String getName() {
        return this.name;
    }

    public String getMoveHistoryAtStage(final long stage) {
        return this.moveHistory.get(stage);
    }

    @Override
    public int compareTo(final Car c) {
        return Long.compare(c.getTotalMoves(), this.getTotalMoves());
    }
}
