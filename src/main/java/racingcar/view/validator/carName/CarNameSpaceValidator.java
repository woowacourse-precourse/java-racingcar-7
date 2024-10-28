package racingcar.view.validator.carName;

import java.util.List;

public class CarNameSpaceValidator extends CarNameValidator {

    @Override
    public void validate(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
        });
    }
}
