package racingcar.domain;

import racingcar.global.ErrorMessage;

public record Rounds(int value) {
    public Rounds {
        validate(value);
    }

    public static Rounds of(String rawInput){
        try {
            return new Rounds(Integer.parseInt(rawInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_REQUIRED.getMessage());
        }
    }

    private void validate(int value){
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
        }
    }
}
