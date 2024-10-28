package racingcar;

import racingcar.enums.Delimiter;
import racingcar.enums.ErrorText;
import racingcar.enums.Limits;

import java.util.LinkedHashMap;

public class InputParser {
    private final String carNames;

    public InputParser(String carNames) {
        this.carNames = carNames;
    }

    public LinkedHashMap<Car, Integer> splitByComma() {
        LinkedHashMap<Car, Integer> result = new LinkedHashMap<>();
        for (String carName : carNames.split(Delimiter.COMMA.getDelimiter())) {
            if (isDuplicateCarName(result, carName)) {
                throw new IllegalArgumentException(ErrorText.DUPLICATE_CAR_NAME.getErrorText());
            }
            result.put(new Car(carName), Limits.DEFAULT.getValue());
        }
        return result;
    }

    private boolean isDuplicateCarName(LinkedHashMap<Car, Integer> cars, String carName) {
        for (Car car : cars.keySet()) {
            if (car.getCarName().equals(carName)) {
                return true;
            }
        }
        return false;
    }
}
