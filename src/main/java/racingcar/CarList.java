package racingcar;

import view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class CarList {
    List<Car> carList = new ArrayList<Car>();

    public void add(String carName) throws IllegalArgumentException{
        carNameValidation(carName);
        carList.add(new Car(carName));
    }
    public void carNameValidation(String carName) throws IllegalArgumentException{
        isNull(carName);
        isOverSizeCarName(carName);
    }
    private void isOverSizeCarName(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print());
        }
    }
        public static void isNull(String carName) throws IllegalArgumentException{
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
            }
        }
    }
}
