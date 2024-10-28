package racingcar.dto;

public record RawMovingCountInput(
        String rawMovingCount
) {
    public static RawMovingCountInput of(String rawMovingCount) {
        return new RawMovingCountInput(rawMovingCount);
    }
}
