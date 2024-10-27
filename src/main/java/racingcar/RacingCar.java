package racingcar;

public class RacingCar {
    private String name;
    private int moveCount;

    public RacingCar(String name) {
        this.name = name;
        moveCount = 0;
    }

    public String getName() {
        return name;
    }
    public void setMoveCount() {
        moveCount = moveCount + 1;
    }
    public int getMoveCount() {
        return moveCount;
    }
}
