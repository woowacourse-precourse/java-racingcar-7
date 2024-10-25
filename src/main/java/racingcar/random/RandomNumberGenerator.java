package racingcar.random;

public interface RandomNumberGenerator<T extends Number> {
    T pickNumber();
}
