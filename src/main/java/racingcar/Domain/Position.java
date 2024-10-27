package racingcar.Domain;

public class Position {
    private int position = 0;

    public void moveForward() {
        position++;
    }

    public int getValue() {
        return position;
    }
}
