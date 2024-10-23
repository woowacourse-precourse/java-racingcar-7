package racingcar.race.constants;

public enum RaceCriterion {
    MOVING_FORWARD(4),
    MOVING_NOT_FORWARD(3);

    private final int criterion;

    RaceCriterion(int criterion) {
        this.criterion = criterion;
    }

    public int getCriterion() {
        return criterion;
    }
}
