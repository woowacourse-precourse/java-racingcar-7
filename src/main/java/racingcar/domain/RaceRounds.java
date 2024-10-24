package racingcar.domain;

import racingcar.global.ErrorMessage;

public record RaceRounds(int value) {
    public RaceRounds {
        validate(value);
    }

    public void forEach(Runnable action) {
        for (int i = 0; i < value; i++) {
            action.run();
        }
    }

    public static RaceRounds of(String rawInput){
        try {
            return new RaceRounds(Integer.parseInt(rawInput));
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
