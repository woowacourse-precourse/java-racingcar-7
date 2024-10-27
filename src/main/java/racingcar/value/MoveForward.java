package racingcar.value;

public record MoveForward(
    boolean isMovable
) {
    private static final int MOVE_SPECIFICATION = 4;

    public static MoveForward from(final long moveValue) {
        return new MoveForward(moveValue >= MOVE_SPECIFICATION);
    }
}