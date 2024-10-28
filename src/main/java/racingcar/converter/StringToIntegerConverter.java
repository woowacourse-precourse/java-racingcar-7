package racingcar.converter;

public class StringToIntegerConverter implements Converter<String, Integer> {

    public StringToIntegerConverter() {
    }

    @Override
    public Integer convert(String input) {
        return Integer.parseInt(input);
    }
}