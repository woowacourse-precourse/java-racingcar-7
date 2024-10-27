package racingcar.view.validator.carName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameDuplicateValidator extends CarNameValidator{

    @Override
    public void validate(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
