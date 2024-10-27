package racingcar.validation;

import java.util.List;
import racingcar.exception.CarNameException;
import racingcar.exception.TryNumberException;
import racingcar.message.ErrorMessage;

public class InputValidator {

    public static void isCarNameNull(List<String> carNameList) throws CarNameException {
        carNameList.forEach(carName -> {
            if(carName.isBlank()) {
                throw new CarNameException(ErrorMessage.CAR_NAME_NULL_ERROR.getMessage());
            }
        });
    }

    public static void isCarNameOverSize(List<String> carNameList) throws CarNameException {
        carNameList.forEach(carName -> {
            if(carName.length() > 5) {
                throw new CarNameException(ErrorMessage.CAR_NAME_OVERSIZE_ERROR.getMessage());
            }
        });
    }

    public static void isTryNumberNull(String tryNumber) {
        if(tryNumber.isBlank()) {
            throw new TryNumberException(ErrorMessage.TRY_NUMBER_IS_NULL_ERROR.getMessage());
        }
    }

    public static int isTryNumberNotInt(String tryNumber) {
        try{
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new TryNumberException(ErrorMessage.TRY_NUMBER_IS_NOT_INT_ERROR.getMessage());
        }
    }
}
