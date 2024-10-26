package racingcar.model;

public class Car {
    final int START_POSITION = 0;
    private String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    private void setMove(int move) {
        this.move = move;
    }

    public void addMove() {
        this.setMove(this.getMove() + 1);
    }
}
