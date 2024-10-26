package racingcar.view.validator;

import java.util.List;

public class CarNameNumberValidator implements CarNameValidator {

    private static final int CAR_MIN_NUMBER = 2;

    @Override
    public void validate(List<String> carNames) {
        if (carNames.size() < CAR_MIN_NUMBER) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야 합니다.");
        }
    }
}
