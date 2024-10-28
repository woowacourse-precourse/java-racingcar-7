package racingcar.domain.race.constants;

public enum RaceCriterion {
    MOVING_FORWARD(4),
    MOVING_NOT_FORWARD(3),
    ROUND_LOWER_BOUND(1),
    ROUND_DECREMENT(1),
    RACE_END(0),
    NOT_NEGATIVE_LIMIT(0);

    private final int criterion;

    RaceCriterion(int criterion) {
        this.criterion = criterion;
    }

    public int getCriterion() {
        return criterion;
    }
}
