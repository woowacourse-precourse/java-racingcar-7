package racingcar;

public class Movement {
    private int move;

    public Movement(int move) {
        this.move = move;
    }

    public void forward() {
        move++;
    }

    public int currentPlace() {
        return move;
    }

    @Override
    public String toString() {
        return "-".repeat(move);
    }

}
