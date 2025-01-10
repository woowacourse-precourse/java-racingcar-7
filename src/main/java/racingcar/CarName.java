package racingcar;

import exception.CustomIllegalArgException;

public class CarName implements Name {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        checkNameValid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void checkNameValid(String name) {
        if (name.isEmpty()) {
            throw new CustomIllegalArgException("자동차 이름을 입력해주세요");
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new CustomIllegalArgException("자동차 이름은 최대 5자입니다.");
        }
    }
}
