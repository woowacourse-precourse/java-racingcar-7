package racingcar.vo;

public record Position(int value) {

    public static Position of(int value) {
        return new Position(value);
    }

    public static Position init() {
        return new Position(0);
    }

    public Position increase() {
        return new Position(value + 1);
    }
}
