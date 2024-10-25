package racingcar.comparable;

public interface NumberComparable<T extends Number> {
    int compare(T x, T y);
}
