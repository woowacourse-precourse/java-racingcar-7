package racingcar.exception;

public class InputValidator {
    private static final String WHITE_SPACES_REGEX = "^\\s*$";
    private static final String DIGIT_REGEX = "^[0-9]*$";

    public void validateWhitespaces(String carsNames, String repeatTimes) {
        if (carsNames.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException("에러: 아무것도 입력하지 않으셨습니다!");
        }

        if (repeatTimes.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException("에러: 아무것도 입력하지 않으셨습니다!");
        }
    }

    public void validateInvalidCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("에러: 입력된 이름의 길이가 5를 넘어갑니다. 길이 5이하의 이름을 입력해주세요!");
        }
    }

    public void validateRepeatTimesNotDigit(String repeatTimes) {
        if (!repeatTimes.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException("에러: 입력된 반복 횟수에 숫자가 아닌 문자가 포함되어 있습니다!");
        }
    }

    public void validateOutOfRangeRepeatTimes(String repeatTimes) {
        int convertedRepeatTimes;

        try {
            convertedRepeatTimes = Integer.parseInt(repeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러: 0 ~ 2,147.483,647 이외의 숫자는 입력하실 수 없습니다!");
        }

        if (convertedRepeatTimes < 0) {
            throw new IllegalArgumentException("에러: 0 ~ 2,147.483,647 이외의 숫자는 입력하실 수 없습니다!");
        }
    }
}
