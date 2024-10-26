package racingcar.validator.strategies.carnames;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class CarNameDuplicateValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> names) {
        checkForDuplicateNames(names);
    }

    private void checkForDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() < names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

}
