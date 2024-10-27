package racingcar.value;

public class MoveForward {
    private static final int MOVE_SPECIFICATION = 4;

    private final boolean isMovable;

    private MoveForward(boolean isMovable) {
        this.isMovable = isMovable;
    }

    public static MoveForward from(final long moveValue) {
        return new MoveForward(moveValue >= MOVE_SPECIFICATION);
    }

    public boolean isMovable() {
        return isMovable;
    }
}