package racingcar.domain;

public enum CarCondition {
    NAME_LENGTH(5),
    MOVE(4);

    private final int condition;

    CarCondition(int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
