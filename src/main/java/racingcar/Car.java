package racingcar;

import exception.CustomException;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        verifyCarName(name);
        this.name = name;
    }

    public void verifyCarName(String name) {
        if (name.isEmpty()) {
            CustomException.throwException("자동차 이름을 입력해주세요");
        }
        if (name.length() > 5) {
            CustomException.throwException("자동차 이름은 최대 5자입니다.");
        }
    }
}
