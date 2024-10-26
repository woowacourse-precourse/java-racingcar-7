package racingcar;

@FunctionalInterface
public interface MoveCommandExecutor<T> {
    default T stop(T instance) {
        return instance;
    }

    T move(T instance);
}
