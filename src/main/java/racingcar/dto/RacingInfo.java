package racingcar.dto;

public record RacingInfo(
        String carNames,
        int tryCount
) {
    public RacingInfo {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("경기 횟수는 1 이상의 수를 입력해주세요.");
        }
    }
}
