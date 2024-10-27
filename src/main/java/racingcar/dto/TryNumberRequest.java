package racingcar.dto;

public record TryNumberRequest (
        int tryNumber
) {
    public static TryNumberRequest of (int tryNumber) {
        return new TryNumberRequest(tryNumber);
    }
}
