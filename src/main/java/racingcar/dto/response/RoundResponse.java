package racingcar.dto.response;

public record RoundResponse(
        int round
) {
    public static RoundResponse from(int round) {
        return new RoundResponse(round);
    }
}
