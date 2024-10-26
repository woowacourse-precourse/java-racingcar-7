package racingcar;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
