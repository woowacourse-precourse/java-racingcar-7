package racingcar.domain;

public record Position(
        int position
) {
    public static Position newInstance() {
        return new Position(0);
    }

    public Position move() {
        return new Position(position + 1);
    }
}