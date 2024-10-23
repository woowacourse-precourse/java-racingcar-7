package racingcar.domain.player;

public class Position {
    private int currentPosition;

    public Position() {
        this.currentPosition = 0;
    }

    public int addPosition() {
        return currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
