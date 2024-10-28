package racingcar.domain.race.constants;

public enum RaceCriterion {
    MOVING_FORWARD(4),
    MOVING_NOT_FORWARD(3),
    MINIMUM_ROUND(1),
    ROUND_DECREASE(1),
    END_RACE(0),
    NOT_NEGATIVE(0);

    private final int criterion;

    RaceCriterion(int criterion) {
        this.criterion = criterion;
    }

    public int getCriterion() {
        return criterion;
    }
}
