package racingcar.view.validator.carName;

import java.util.List;

public class CarNameLengthValidator extends CarNameValidator{

    private static final int CAR_MAX_LENGTH = 5;

    @Override
    public void validate(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.length() > CAR_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        });
    }
}
