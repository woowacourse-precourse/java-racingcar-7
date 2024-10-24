package racingcar.domain;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5글자를 초과합니다.");
        }
    }
}
