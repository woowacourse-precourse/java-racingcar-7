package racingcar.value;

public record TotalLaps(
    Long count
) {

    public static TotalLaps from(final long value) {
        return new TotalLaps(value);
    }
}
