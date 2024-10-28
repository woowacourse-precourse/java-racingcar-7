package racingcar.view.validator.carName;

import java.util.List;

public class CarNameDelimiterValidator extends CarNameValidator {

    @Override
    public void validate(List<String> carNames) {
        carNames.forEach(carName -> {
            if (!carName.matches("[\\w]+")) {
                throw new IllegalArgumentException("자동차 이름 구분자는 쉼표(,)만 가능합니다.");
            }
        });
    }
}
