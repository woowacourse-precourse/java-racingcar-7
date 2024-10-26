package racingcar.util.random;

public interface RandomNumberGenerator<T extends Number> {
    T pickNumber();
}
