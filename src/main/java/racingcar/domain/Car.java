package racingcar.domain;

public class Car {
    private final String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public void addMove() {
        move++;
    }
}
