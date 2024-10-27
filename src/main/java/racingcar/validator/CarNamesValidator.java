package racingcar.validator;

import java.util.ArrayList;
import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.exception.ErrorMessage.TOO_LONG_NAME;
import static racingcar.exception.ErrorMessage.DUPLICATION;

public class CarNamesValidator {

    public static void validate(ArrayList<String> carNames) {
        validateNotEmptyInput(carNames);
        validateCarNameNotEmpty(carNames);
        validateLength(carNames);
        validateDuplication(carNames);
    }

    private static  void validateNotEmptyInput(ArrayList<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void validateCarNameNotEmpty(ArrayList<String> carNames){
        for( String carName: carNames){
            if (carName.trim().isEmpty()){
                throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
            }
        }
    }

    private static void validateLength(ArrayList<String> carNames) {
        for ( String carName : carNames ) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(TOO_LONG_NAME.getMessage());
            }
        }
    }

    private static void validateDuplication(ArrayList<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATION.getMessage());
        }
    }

}
