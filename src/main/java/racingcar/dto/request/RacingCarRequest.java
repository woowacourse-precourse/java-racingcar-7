package racingcar.dto.request;

public record RacingCarRequest(
        String carNames,
        int tryCount
) {
    public static RacingCarRequest of(String carNames, int tryCount) {
        return new RacingCarRequest(carNames, tryCount);
    }
}
