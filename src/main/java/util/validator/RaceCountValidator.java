package util.validator;

public class RaceCountValidator {

    private static final int MIN_RACE_COUNT = 1;  // 최소 반복 횟수
    private static final int MAX_RACE_COUNT = 100; // 최대 반복 횟수 (필요에 따라 조정)

    private enum ErrorMessage {
        INVALID_MIN_RACE_COUNT("반복 횟수는 1 이상으로 입력해야 합니다."),
        INVALID_MAX_RACE_COUNT("반복 횟수는 100 이하로 입력해야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void validate(int raceCount) {
        validateMinRaceCount(raceCount);
        validateMaxRaceCount(raceCount);
    }

    private void validateMinRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MIN_RACE_COUNT.getMessage());
        }
    }

    private void validateMaxRaceCount(int raceCount) {
        if (raceCount > MAX_RACE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MAX_RACE_COUNT.getMessage());
        }
    }
}
