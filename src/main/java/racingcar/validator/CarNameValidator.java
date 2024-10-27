package racingcar.validator;

import static racingcar.Constatns.CAR_NAME_CONDITION_ERROR_MESSAGE;

public class CarNameValidator {
    public static void carNameValidator(String name){
        if(name.isEmpty() || name.length()>5 || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_CONDITION_ERROR_MESSAGE);
        }
    }
}
