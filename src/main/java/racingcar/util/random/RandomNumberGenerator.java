package racingcar.util.random;

@FunctionalInterface
public interface RandomNumberGenerator<T extends Number> {
    T pickNumber();
}
