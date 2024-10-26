package racingcar.car;

public class RacingCar {
    private static final int THRESHOLD = 4;

    private final String name;
    private int moveCount;

    private RacingCar(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public static RacingCar of(String name) {
        return new RacingCar(name, 0);
    }

    public void increaseMoveCount() {
        moveCount += 1;
    }

    public boolean isMoveCountEqualTo(int count) {
        return moveCount == count;
    }

    public void moveIfRandomNumberIsAbove(int number) {
        if (number >= THRESHOLD) {
            increaseMoveCount();
        }
    }

    public String getProgress() {
        return "-".repeat(moveCount);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
