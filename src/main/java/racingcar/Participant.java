package racingcar;

public class Participant {
    private String carName;
    private int moveCount;

    public Participant() {

    }

    public Participant(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void plusMoveCount() {
        this.moveCount++;
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(moveCount);
    }
}
