package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorMessage;

public class CarNamesValidator {

    public void validateCarNamesInput(String carNames) {

        if (carNames.isEmpty()) {
            throw new CustomException(ErrorMessage.EMPTY_CAR_NAMES);
        }
        if (!carNames.contains(",")) {
            throw new CustomException(ErrorMessage.COMMA_NOT_EXIST);
        }
    }

    public void validateCarNamesList(List<String> listCarNames) {
        if (isDuplicateCarName(listCarNames)) {
            throw new CustomException(ErrorMessage.DUPLICATE_CAR_NAME);
        }

        for (String carName : listCarNames) {
            if (carName.length() > 5) {
                throw new CustomException(ErrorMessage.LONG_CAR_NAME);
            }
        }
    }

    public boolean isDuplicateCarName(List<String> listCarNames) {
        Set<String> checkCarName = new HashSet<>(listCarNames);

        return listCarNames.size() != checkCarName.size();
    }
}
