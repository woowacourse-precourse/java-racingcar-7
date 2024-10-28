package racingcar.domain.car.service;

public class CarNameValidator {
    public static void validate(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
