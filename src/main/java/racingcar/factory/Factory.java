package racingcar.factory;

public interface Factory<T> {
    T create(String type);
}
