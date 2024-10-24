package racingcar.domain;

public class Count<T extends Number>{

    private final T value;

    public Count(final T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
