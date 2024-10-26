package racingcar.validation;

import java.util.List;
import racingcar.exception.CarNameException;
import racingcar.message.ErrorMessage;

public class CarNameValidator {

    public static void isNull(String carNames) throws CarNameException {
        if(carNames.isBlank()) {
            throw new CarNameException(ErrorMessage.CAR_NAME_NULL_ERROR.getMessage());
        }
    }

    public static void isOverSize(List<String> carNameList) throws CarNameException {
        carNameList.forEach(carName -> {
            if(carName.length() > 5) {
                throw new CarNameException(ErrorMessage.CAR_NAME_OVERSIZE_ERROR.getMessage());
            }
        });
    }

}
