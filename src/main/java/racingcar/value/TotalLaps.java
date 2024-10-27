package racingcar.value;

public record TotalLaps(
    Long count
) {
    private static final Long MIN_SIZE = 1L;

    public TotalLaps {
        if (count < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}