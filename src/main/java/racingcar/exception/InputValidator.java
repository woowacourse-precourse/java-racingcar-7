package racingcar.exception;

public class InputValidator {
    private static final String WHITE_SPACES_REGEX = "^\\s*$";

    public void validateWhitespaces(String carsNames, String repeatTimes) {
        if (carsNames.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException("에러: 아무것도 입력하지 않으셨습니다!");
        }

        if (repeatTimes.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException("에러: 아무것도 입력하지 않으셨습니다!");
        }
    }
}
