package racingcar.application.converter;

public abstract class InputStringConverter<T> {

    public final T convert(String input) {
        validate(input);
        return doConvert(input);
    }

    protected abstract T doConvert(String input);

    protected abstract void validate(String input);
}
