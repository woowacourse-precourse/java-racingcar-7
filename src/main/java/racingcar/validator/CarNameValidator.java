package racingcar.validator;

public class CarNameValidator {
    private static final int STANDARD_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "이름은 5자 이하만 가능합니다.";
    private static final String EMPTY_CAR_NAME = "이름이 빈 값 입니다.";

    public void isValidCarName(String name){
        isNotEmpty(name);
        isLengthUnderFive(name);
    }

    private void isNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private void isLengthUnderFive(String name) {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

}
