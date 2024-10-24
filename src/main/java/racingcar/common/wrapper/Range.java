package racingcar.common.wrapper;

public record Range(Integer min, Integer max) {
    public static Range of(Integer min, Integer max) {
        return new Range(min, max);
    }
}
