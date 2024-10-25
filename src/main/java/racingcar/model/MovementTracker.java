package racingcar.model;

public class MovementTracker {
    protected static final String DEFAULT_MOVEMENT= "";
    protected static final String DEFAULT_MOVEMENT_MARK = "-";

    private String movement;
    private final String movementMark;

    public MovementTracker() {
        this.movement = DEFAULT_MOVEMENT;
        this.movementMark = DEFAULT_MOVEMENT_MARK;
    }

    public void recordMovement(int speed) {
        movement += movementMark.repeat(speed);
    }

    public String getMovement() {
        return movement;
    }
}
