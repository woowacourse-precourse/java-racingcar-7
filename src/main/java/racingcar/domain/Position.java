package racingcar.domain;

public record Position(int position) implements Comparable<Position> {

    public static final Position ZERO = new Position(0);

    public Position move() {
        return new Position(position + 1);
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}
