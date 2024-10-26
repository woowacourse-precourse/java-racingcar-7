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

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "carName='" + carName + '\'' +
                ", moveCount=" + moveCount +
                '}';
    }
}
