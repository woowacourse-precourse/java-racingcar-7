package racingcar.validator;

public class CarNameValidator {
    private static final int STANDARD_NAME_LENGTH = 5;

    public void isLengthUnderFive(String[] names) {
        for (String name : names) {
            if (name.length() > STANDARD_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void isNotEmpty(String[] names) {
        for (String name : names) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("이름이 빈 값 입니다.");
            }
        }
    }

}
