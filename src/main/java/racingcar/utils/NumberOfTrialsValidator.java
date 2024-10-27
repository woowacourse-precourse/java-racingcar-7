package racingcar.utils;

public class NumberOfTrialsValidator implements InputValidator {

    // 매직 넘버를 상수로 처리
    private static final int MIN_TRIALS_NUMBER = 1;

    @Override
    public void validate(String numberOfTrialsInput) {
        int numberOfTrials = parseNumberOfTrials(numberOfTrialsInput);
        if (numberOfTrials < MIN_TRIALS_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRIALS_NUMBER);
        }
    }

    private int parseNumberOfTrials(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.TRIALS_NOT_A_NUMBER);
        }
    }
}
