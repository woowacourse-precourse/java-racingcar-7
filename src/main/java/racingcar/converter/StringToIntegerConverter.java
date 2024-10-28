package racingcar.converter;

import racingcar.enums.ErrorMessage;

public class StringToIntegerConverter implements Converter<String, Integer> {

    public StringToIntegerConverter() {
    }

    @Override
    public Integer convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}