package racingcar.validator;

import java.util.List;

public class CarValidator {

    public void validateInputCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    public void validateAllCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarName(name);
        }
    }

    public void validateCarName(String CarName) {
        final int MAX_CAR_NAME_LENGTH = 5;

        if (CarName == null || CarName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (CarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 입력된 이름: " + CarName);
        }
    }

}
