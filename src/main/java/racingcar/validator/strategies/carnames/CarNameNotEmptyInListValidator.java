package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class CarNameNotEmptyInListValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_IN_LIST.getMessage());
            }
        }
    }

}
