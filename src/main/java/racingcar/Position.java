package racingcar;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(String.format("자동차 position 은 음수일 수 없습니다. 현재 포지션: (%d)", position));
        }
        this.position = position;
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return position == winnerPosition;
    }

    public Position goForward() {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    public int getPosition() {
        return position;
    }
}
