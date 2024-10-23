package racingcar.domain;

public record Position(int value) {
    public Position {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public Position increase() {
        return new Position(value + 1);
    }
}

