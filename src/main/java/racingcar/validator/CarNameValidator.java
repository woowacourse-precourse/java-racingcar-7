package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

import static racingcar.constants.Constants.*;

public class CarNameValidator {

    public void nameLength(List<String> carsList) {
        for (String car : carsList) {
            if (car.isEmpty() || car.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void nameOverlap(List<String> carsList) {
        if (carsList.size() != carsList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void rightNamePattern(String cars) {
        if (!Pattern.compile(CAR_LIST_PATTERN).matcher(cars).matches()) {
            throw new IllegalArgumentException();
        }
    }
}

