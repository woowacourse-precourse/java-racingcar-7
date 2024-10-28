package racingcar.wrapper;

import racingcar.validator.CarNameValidator;

public class CarName {

    private final String name;

    private CarName(String name) {
        validateMinNameLength(name);
        validateMaxNameLength(name);
        this.name = name.trim();
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    private void validateMaxNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateMinNameLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

}

