package racingcar.domain.game;

import racingcar.global.ErrorMessage;

public record RaceRounds(int value) {
    private static final int MINIMUM_ROUNDS = 0;
    private static final int INITIAL_INDEX = 0;

    public RaceRounds {
        validate(value);
    }

    public void forEach(Runnable action) {
        for (int i = INITIAL_INDEX; i < value; i++) {
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
        if (value < MINIMUM_ROUNDS) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
        }
    }
}