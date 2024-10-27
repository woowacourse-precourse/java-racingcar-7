package racingcar.dto.request;

public record RoundRequest(
        String round
) {
    public static RoundRequest from(String round) {
        return new RoundRequest(round);
    }
}
