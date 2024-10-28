package racingcar.support.comparable;

@FunctionalInterface
public interface NumberComparable<T extends Number> {
    boolean meetsThreshold(T value, T threshold);
}
