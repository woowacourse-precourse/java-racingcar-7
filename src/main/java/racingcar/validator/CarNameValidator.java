package racingcar.validator;

import java.util.List;

public class CarNameValidator {

    private static final int NAME_MAX_LENGTH = 5;

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
}

