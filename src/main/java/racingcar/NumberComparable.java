package racingcar;

public interface NumberComparable<T extends Number> {
    int compare(T x, T y);
}
