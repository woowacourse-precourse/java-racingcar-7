package racingcar.controller;

public class Validation {

    public void carNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
        }
    }

    public void isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력값을 넣지 않았습니다.");
        }

    }
}
