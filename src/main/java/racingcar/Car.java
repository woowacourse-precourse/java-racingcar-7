package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int moves = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovable(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public void moveForward() {
        this.moves += 1;
    }

    public void printMoves() {
        System.out.println(this.name + " : " + "-".repeat(this.moves));
    }
}
