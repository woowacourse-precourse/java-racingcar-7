package racingcar.support.random;

@FunctionalInterface
public interface RandomNumberGenerator<T extends Number> {
    T pickNumber();
}
