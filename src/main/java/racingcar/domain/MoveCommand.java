package racingcar.domain;

public enum MoveCommand {
    MOVE {
        @Override
        public <T> T execute(T instance, MoveCommandExecutor<T> item) {
            return item.move(instance);
        }
    }, STOP {
        @Override
        public <T> T execute(T instance, MoveCommandExecutor<T> item) {
            return item.stop(instance);
        }
    };

    public abstract <T> T execute(T instance, MoveCommandExecutor<T> item);
}
