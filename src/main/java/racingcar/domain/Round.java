package racingcar.domain;

public record Round(int value) {
    public Round {
        if (value <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상으로 입력해야합니다.");
        }
    }
}
