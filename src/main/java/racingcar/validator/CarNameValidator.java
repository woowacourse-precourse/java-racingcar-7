package racingcar.validator;

public class CarNameValidator {
    private static final int STANDARD_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "이름은 5자 이하만 가능합니다.";
    private static final String EMPTY_CAR_NAME = "이름이 빈 값 입니다.";

    public void isLengthUnderFive(String[] names) {
        for (String name : names) {
            if (name.length() > STANDARD_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
            }
        }
    }

    public void isNotEmpty(String[] names) {
        for (String name : names) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_CAR_NAME);
            }
        }
    }

}
