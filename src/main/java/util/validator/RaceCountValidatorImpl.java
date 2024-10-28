package util.validator;

public class RaceCountValidatorImpl implements Validator<Integer> {
    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 100;

    @Override
    public void validate(Integer raceCount) {
        validateMinRaceCount(raceCount);
        validateMaxRaceCount(raceCount);
    }

    private void validateMinRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT) {
            throw new IllegalArgumentException(Message.INVALID_MIN_RACE_COUNT.getMessage());
        }
    }

    private void validateMaxRaceCount(int raceCount) {
        if (raceCount > MAX_RACE_COUNT) {
            throw new IllegalArgumentException(Message.INVALID_MAX_RACE_COUNT.getMessage());
        }
    }
}
