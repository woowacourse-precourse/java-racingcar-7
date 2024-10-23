package racingcar;

public class CarName {
    private static final int STANDARD_NAME_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        isLengthUnderFive(name);
        isNotEmpty(name);
    }

    private boolean isLengthUnderFive(String name) {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        return true;
    }

    private boolean isNotEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 빈 값 입니다.");
        }
        return true;
    }

    public String getName(){
        return this.name;
    }
}
