package racingcar.view.validator.carName;

import java.util.List;

public class CarNameNullValidator extends CarNameValidator{

    @Override
    public void validate(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        });
    }
}
