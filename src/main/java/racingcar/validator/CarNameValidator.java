package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
import racingcar.enums.Constraints;
import racingcar.enums.Exceptions;
import racingcar.enums.StringPattern;

public class CarNameValidator {
    public void validateCarNamesInput(String input) {
        validateFullString(input);
        validateEachCarName(input);
    }

    private void validateFullString(String input) {
        validateNotBlank(input);
        validateNoSpace(input);
        validateEnd(input);
    }

    private void validateEachCarName(String input) {
        String[] carNames = input.split(StringPattern.CAR_NAME_DELIMITER.getValue());
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            validateEmptyName(carName);
            validateCarNameLength(carName);
            carNameSet.add(carName);
        }
        validateDuplication(carNameSet.size(), carNames.length);
    }

    private void validateNotBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(Exceptions.INVALID_CAR_NAME_EMPTY.getMessage());
        }
    }


    private void validateNoSpace(String input) {
        if(input.contains(" ")){
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_WHITESPACE.getMessage());
        }
    }

    private void validateEnd(String input) {
        String a = StringPattern.CAR_NAME_DELIMITER.getValue();
        if(input.endsWith(StringPattern.CAR_NAME_DELIMITER.getValue())){
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_END.getMessage());
        }
    }

    private void validateEmptyName(String carName) {
        if(carName.isEmpty()){
            throw new IllegalArgumentException(Exceptions.INVALID_CAR_NAME_EMPTY.getMessage());
        }
    }

    private void validateCarNameLength(String carName) {
        if(carName.length() > Constraints.MAX_CAR_NAME_LENGTH.getValue()){
            throw new IllegalArgumentException(Exceptions.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private void validateDuplication(int setSize, int carNameLength) {
        if(setSize!=carNameLength){
            throw new IllegalArgumentException(Exceptions.INVALID_CAR_NAME_DUPLICATION.getMessage());
        }
    }


}
