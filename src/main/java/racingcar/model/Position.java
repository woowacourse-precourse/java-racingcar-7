package racingcar.model;

public class Position {
    private Integer position;

    public Position() {
        this.position = 0;
    }

    public void moveForward() {
        position++;
    }

    public Integer getPosition() {
        return position;
    }
}
