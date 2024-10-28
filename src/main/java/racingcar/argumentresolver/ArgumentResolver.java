package racingcar.argumentresolver;

public interface ArgumentResolver<T> {
    T parse(String parameter);
}
