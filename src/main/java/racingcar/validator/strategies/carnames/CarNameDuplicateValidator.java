package racingcar.validator.strategies.carnames;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 중복되는 자동차 이름 검증
 */
public class CarNameDuplicateValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> names) {
        validateNoDuplicateNames(names);
    }

    private void validateNoDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() < names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }
}

