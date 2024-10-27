package racingcar.dto.request;

public record RacingCarRequest(
    String carNames
) {
    public static RacingCarRequest from(String carNames) {
        return new RacingCarRequest(carNames);
    }
}