package racingcar.validator;

public class RaceRoundsValidator {

    public int validateRoundsInput(String roundsInput) {
        if (roundsInput == null || roundsInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            int raceRounds = Integer.parseInt(roundsInput.trim());
            if (raceRounds < 0) {
                throw new IllegalArgumentException();
            }
            return raceRounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
