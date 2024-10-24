package racingcar.domain;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        validateBlankOrEmptyName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5를 초과할 수 없습니다.");
        }
    }

    private void validateBlankOrEmptyName(String name) {
        if(name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이거나 null 일 수 없습니다.");
        }
    }
}
