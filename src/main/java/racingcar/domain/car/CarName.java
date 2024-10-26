package racingcar.domain.car;

import racingcar.constant.Constant;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateNameBlank(name);
        validateNameTooLong(name);
        this.name = name;
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 지정하지 않은 자동차가 있습니다.");
        }
    }

    private void validateNameTooLong(String name) {
        if (name.length() > Constant.CAR_NAME_LENGTH_CRITERIA) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 설정해 주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
