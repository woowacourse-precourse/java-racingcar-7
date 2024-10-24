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

    public void validateInvalidCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("에러: 입력된 이름의 길이가 5를 넘어갑니다. 길이 5이하의 이름을 입력해주세요!");
        }
    }
}
