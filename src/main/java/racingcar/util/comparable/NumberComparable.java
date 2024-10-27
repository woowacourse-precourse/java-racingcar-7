package racingcar.util.comparable;

@FunctionalInterface
public interface NumberComparable<T extends Number> {
    int compare(T x, T y);
}
