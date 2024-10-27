package racingcar.game.model;

public class Position {
    private static final Integer MOVE_CONDITION = 4;
    private Integer position;

    public Position() {
        this.position = 0;
    }

    public void move(Integer number) {
        if (number >= MOVE_CONDITION) {
            this.position = ++position;
        }
    }

    public Integer getPosition() {
        return position;
    }
}
