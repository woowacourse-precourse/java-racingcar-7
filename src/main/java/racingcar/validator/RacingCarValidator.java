package racingcar.validator;

public class RacingCarValidator {
    private static final Integer NAME_MIN_LENGTH = 1;
    private static final Integer NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR = "레이싱 카 이름의 길이는 1 이상 5 이하여야 합니다.";

    public RacingCarValidator() {
    }

    public void validateCarName(String carName) {
        if (carName.length() < NAME_MIN_LENGTH || carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }
}
