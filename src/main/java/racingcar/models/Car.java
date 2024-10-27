package racingcar.models;

public class Car {
    private static final int INIT_MOVES = 0;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = INIT_MOVES;
    }

    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    public void makeMove(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            this.moves += 1;
        }
    }

    public String printMoves() {
        return this.name + " : " + "-".repeat(this.moves) + "\n";
    }
}
