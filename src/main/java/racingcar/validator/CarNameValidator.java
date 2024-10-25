package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator {

    private static final int NAME_MAX_LENGTH = 5;
    //    private static final String CAR_LIST_PATTERN = "^([a-zA-Z0-9가-힣])(,[a-zA-Z0-9가-힣])*$";
    private static final String CAR_LIST_PATTERN = "^[a-zA-Z0-9가-힣]+[a-zA-Z0-9가-힣" + "," + "]*[a-zA-Z0-9가-힣]";

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

