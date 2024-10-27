package racingcar.validator;

import java.util.List;

import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.exception.ErrorMessage.TOO_LONG_NAME;
import static racingcar.exception.ErrorMessage.DUPLICATION;
import static racingcar.exception.ErrorMessage.SPACES_NOT_ALLOWED;

public class CarNamesValidator {

    public static void validate(List<String> carNames) {
        validateNotEmptyInput(carNames);
        validateCarNameNotEmpty(carNames);
        validateCarNameNoSpace(carNames);
        validateLength(carNames);
        validateDuplication(carNames);
    }

    private static  void validateNotEmptyInput(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void validateCarNameNotEmpty(List<String> carNames){
        for( String carName: carNames){
            if (carName.trim().isEmpty()){
                throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
            }
        }
    }

    private static void validateLength(List<String> carNames) {
        for ( String carName : carNames ) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(TOO_LONG_NAME.getMessage());
            }
        }
    }

    private static void validateDuplication(List<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATION.getMessage());
        }
    }

    private static void validateCarNameNoSpace(List<String> carNames) {
        for( String carName : carNames ){
            if (carName.contains(" ")) {
                throw new IllegalArgumentException(SPACES_NOT_ALLOWED.getMessage());
            }
        }
    }

}
