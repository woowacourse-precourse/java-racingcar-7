package racingcar.validation;

import racingcar.exception.CustomException;
import racingcar.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void checkNameLength(String car){
        if(car.length() > 5){
            throw new CustomException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    public static void checkNameNull(String car){
        if(car.isBlank()){
            throw new CustomException(ErrorMessage.INVALID_NAME_INPUT);
        }
    }

    public static int checkIfNumber(String number){
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new CustomException(ErrorMessage.INVALID_NUMBER);
        }
    }

    public static void checkDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new CustomException(ErrorMessage.DUPLICATE_NAME);
        }
    }

}
