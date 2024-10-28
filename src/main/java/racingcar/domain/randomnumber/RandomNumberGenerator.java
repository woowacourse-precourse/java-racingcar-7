package racingcar.domain.randomnumber;

public interface RandomNumberGenerator<T extends Number> {
    T pickNumber();
}
